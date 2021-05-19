package com.inatel.stockquotemanager.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Quotes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String data;
	private Double valor;
	@ManyToOne
	private Stock stock;

	
	public Quotes() {
}

	public Quotes(Stock stock2, String data2, Double valor2) {
         this.data = data2;
         this.valor = valor2;
         this.stock = stock2;
                 
         
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
