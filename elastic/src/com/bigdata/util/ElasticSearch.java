package com.bigdata.util;

import java.util.logging.Logger;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.json.JSONObject;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

import com.bigdata.constants.ElasticSearchConfig;
import com.bigdata.service.ElasticSearchService;
import com.bigdata.model.Crime;

public class ElasticSearch implements ElasticSearchService {
	private static final int REGISTROS_REQUISICAO = 1000;
	private final Node nodeElasticSearch;
	private final Client clientElasticSearch;
	private final BulkProcessor bulkProcessor;
	private static final JSONObject object = new JSONObject();//usar json

	public static <T> String paserObjectToJson(final Crime pojo) {
		
	     JSONObject values = new JSONObject();
	     try {
	    	 values.put("id_teste",pojo.getId_teste());
	    	 values.put("offense", pojo.getOffense());
	    	 values.put("quant", pojo.getQuant());
	         object.put("values",values);
	     }catch(Exception ex){}
	     return object.toString();
	}
	
//	public static <T> Crime paserJsonToObject(final String json, final Class<Crime> pojo) {
//		return object.fromJson(json, pojo);
//	}
	
	public ElasticSearch() {
		
		this.nodeElasticSearch = NodeBuilder.nodeBuilder().settings(Settings.builder().put("path.home", "localhost")).node();
		//this.nodeElasticSearch = NodeBuilder.nodeBuilder().node();
		this.clientElasticSearch = montarConexaoClient(nodeElasticSearch);
		this.bulkProcessor = inicializarBulkProcessor() ;
		System.setProperty("hadoop.home.dir", "C:/winutils");
		
	}
	
	private Client montarConexaoClient(final Node node) {
		return node.client();
	}

	public <T> void addIndiceRequisicao(final String indice, final String tipo, final String id, final Crime crime) {
		IndexRequest indexRequest = new IndexRequest(indice, tipo, id).source(paserObjectToJson(crime));
		bulkProcessor.add(indexRequest);
		bulkProcessor.flush();
	}
	
	public void criarIndiceMapeamentoDefeito(){

		try {
			clientElasticSearch.admin().indices()
			.prepareCreate(ElasticSearchConfig.INDICE.getValor())
			.execute().actionGet();
		} catch (Exception e) {
			System.out.print(String.format("O index: %s já existe no Elasticseach.", ElasticSearchConfig.INDICE.getValor()));
		}
		try {
		
			clientElasticSearch.admin().indices()
			.preparePutMapping(ElasticSearchConfig.MAPPING.getValor())
			.setType(ElasticSearchConfig.TIPO.getValor())
			.setSource(ElasticSearchConfig.INDICE.getValor()).execute().actionGet();
		} catch (Exception e) {
			System.out.print("Ocorreu erro ao executar o mapeamento do defeito: " + e);
		}
		
	}

	public void closeConnection() {
		
		if (!NodeBuilder.nodeBuilder().node().isClosed()) {
			bulkProcessor.close();
			clientElasticSearch.close();
			nodeElasticSearch.close();
		}
	}
	
	private BulkProcessor inicializarBulkProcessor() {
		BulkProcessor bulkProcessor = BulkProcessor
				.builder(clientElasticSearch, new BulkProcessor.Listener() {
					public void beforeBulk(long executionId, BulkRequest request) {
						System.out.print(String.format("Going to execute new bulk composed of %s actions", request.numberOfActions()));
					}

					public void afterBulk(long executionId,
							BulkRequest request, BulkResponse response) {
						System.out.print(String.format("Executed bulk composed of %s actions", request.numberOfActions()));
					}

					public void afterBulk(long executionId,
							BulkRequest request, Throwable failure) {
						System.out.print("Falha na execução: "+ failure);
					}
				}).setBulkActions(REGISTROS_REQUISICAO).setConcurrentRequests(1).build();
		
		return bulkProcessor;
	}

	

}
