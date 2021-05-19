package com.inatel.stockquotemanager.demo.Controller.Dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;


import com.inatel.stockquotemanager.demo.Model.Stock;



public class StockQuoteDto {

	private String id;
	private List<QuotesDto> quote;
	
	

	public StockQuoteDto(Stock stock) {
		
		this.id = stock.getId();
		this.quote = new ArrayList<>();
		this.quote.addAll(stock.getQuotes().stream().map(QuotesDto::new).collect(Collectors.toList()));
	}

	public List<QuotesDto> getQuote() {
		return quote;
	}

	public String getId() {
		return id;
	}

	public static Page<StockQuoteDto> converter(Page<Stock> stock) {
		
		return stock.map(StockQuoteDto::new);
	}

	


}
