package com.inatel.stockquotemanager.demo.Controller;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class StockService {
	static RestTemplate restTemplate; 
	static String url = "http://localhost:8080"; 
	
	
	public StockService() {
		restTemplate = new RestTemplate();
	}

	public static String get(){
		String stock = restTemplate.getForObject(url + "/stock",String.class);
		
		return stock;
		
	}

	
}
