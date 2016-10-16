package com.bigdata.service;

import com.bigdata.model.Crime;

public interface ElasticSearchService {
	
	/**
	 * Adiciona indice na Requisicao Bulk ES
	 *  
	 * @param indice
	 * @param tipo
	 * @param pojo
	 */
	<T> void addIndiceRequisicao(final String indice, final String tipo,final String id, Crime crime);
	
	
	/**
	 * Cria o mapeamento do defeito
	 */
	void criarIndiceMapeamentoDefeito();

	/**
	 * Fecha a conexão com o cliente do ES
	 */
	void closeConnection();
}