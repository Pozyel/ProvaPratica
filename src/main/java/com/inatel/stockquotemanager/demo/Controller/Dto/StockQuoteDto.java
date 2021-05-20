package com.inatel.stockquotemanager.demo.Controller.Dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.inatel.stockquotemanager.demo.Model.Quotes;
import com.inatel.stockquotemanager.demo.Model.Stock;

public class StockQuoteDto {

	private String id;
	//private List<QuotesDto> quote;
	private Map<String, String> quotes = new HashMap<>();

	public StockQuoteDto(String id, List<Quotes> quotes) {

		this.id = id;
		this.quotes = ConverterQuotesParaMapa(quotes);
	}

	public StockQuoteDto(Stock stock) {

		this.id = stock.getId();
		//this.quote = new ArrayList<>();
		//this.quote.addAll(stock.getQuotes().stream().map(QuotesDto::new).collect(Collectors.toList()));
	}

	//public List<QuotesDto> getQuote() {
	//	return quote;
	//}

	public String getId() {
		return id;
	}

	public static Page<StockQuoteDto> converter(Page<Stock> stock) {

		return stock.map(StockQuoteDto::new);
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}

	private Map<String, String> ConverterQuotesParaMapa(List<Quotes> quoteList) {
		Map<String, String> quotesMap = new HashMap<String, String>();
		quoteList.forEach(quote -> {
			LocalDate data = quote.getData();
			Double valor = quote.getValor();

			quotesMap.put(data.toString(), valor.toString());
		});
		return quotesMap;
	}

}
