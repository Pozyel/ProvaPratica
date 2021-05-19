package com.inatel.stockquotemanager.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stock {

	@Id
	private String id;
	@OneToMany(mappedBy = "stock")
	private List<Quotes> quotes = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Quotes> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quotes> quotes) {
		this.quotes = quotes;
	}

	public Stock() {
	}

	public Stock(String id) {

		this.id = id;
	}

}
