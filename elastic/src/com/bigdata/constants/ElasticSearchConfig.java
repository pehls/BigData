package com.bigdata.constants;	

public enum ElasticSearchConfig {
	
	INDICE("teste"),
	TIPO("values"),
	TIPO_PROJECT("projeto"),
	MAPPING(																															
			"{\"values\":{\"quant\":\"long\",\"offense\":\"string\",\"id_teste\":\"long\"}}");
	
	private String valor;
	
	private ElasticSearchConfig(final String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
}