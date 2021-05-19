package com.inatel.stockquotemanager.demo.Controller.Dto;


import com.inatel.stockquotemanager.demo.Model.Quotes;

public class QuotesDto {

	private String data;
	private Double valor;
	

	public String getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}
	

	

	public QuotesDto(Quotes quotes) {
		this.data = quotes.getData();
		this.valor = quotes.getValor();
		
	}

	
}
