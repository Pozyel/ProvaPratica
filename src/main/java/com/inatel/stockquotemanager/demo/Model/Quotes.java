package com.inatel.stockquotemanager.demo.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Quotes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate data;
	private Double valor;
	@ManyToOne
	private Stock stock;

	
	public Quotes() {
}

	public Quotes(LocalDate data2, Double valor2,Stock stock2) {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
