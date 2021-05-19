package com.inatel.stockquotemanager.demo.Controller.Form;




import java.util.Optional;

import com.inatel.stockquotemanager.demo.Model.Quotes;
import com.inatel.stockquotemanager.demo.Model.Stock;
import com.inatel.stockquotemanager.demo.Repository.StockRepository;


public class QuoteForm {

	private String data;
	private Double valor;
	private String id;

	public String getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Quotes converter(StockRepository stockRepository) {
		Optional<Stock> stock = stockRepository.findById(this.id);
		if(stock.isEmpty()) {
			Stock salvaStock = new Stock(this.id);
			stockRepository.save(salvaStock);
			return new Quotes(salvaStock,data,valor);
		}
		
		return new Quotes(stock.get(),data,valor);
	}

}
