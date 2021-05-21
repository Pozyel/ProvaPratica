package com.inatel.stockquotemanager.demo.Controller.Form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.inatel.stockquotemanager.demo.Model.Quotes;
import com.inatel.stockquotemanager.demo.Model.Stock;
import com.inatel.stockquotemanager.demo.Repository.StockRepository;

public class StockQuoteForm {

	private String id;
	private Map<String, String> quotes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, String> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, String> quotes) {
		this.quotes = quotes;
	}
	

	public List<Quotes> ConverteMapa(StockRepository stockRepository) {
		List<Quotes> quoteLista = new ArrayList<Quotes>();
		Optional<Stock> stock = stockRepository.findById(this.id);
		if (stock.isEmpty()) {
			Stock salvaStock = new Stock(this.id);
			stockRepository.save(salvaStock);

			for (Map.Entry<String, String> quotes : this.quotes.entrySet()) {

				
				Quotes quote = new Quotes( LocalDate.parse(quotes.getKey()), Double.parseDouble(quotes.getValue()),salvaStock);
				quoteLista.add(quote);

				
			}
			return quoteLista;

		}
		for (Map.Entry<String, String> quotes : this.quotes.entrySet()) {

			Quotes quote = new Quotes( LocalDate.parse(quotes.getKey()), Double.parseDouble(quotes.getValue()),stock.get());
			quoteLista.add(quote);

			

		}
		return quoteLista;
	}

}
