package com.inatel.stockquotemanager.demo.Controller;





import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inatel.stockquotemanager.demo.Controller.Dto.IdStockDto;


@Service
public class StockService {
	static RestTemplate restTemplate; 
	static String url = "http://localhost:8080"; 
	
	
	public StockService() {
		restTemplate = new RestTemplate();
	}

	@Cacheable(value = "stock")
	public static String get(String id){
		String stock = restTemplate.getForObject(url + "/stock/"+id,String.class);
		return stock;
		
	}
	@Cacheable(value = "stocklista")
	public static IdStockDto[] getAll(){
		ResponseEntity<IdStockDto[]> stock = restTemplate.getForEntity(url + "/stock",IdStockDto[].class);
		IdStockDto[] id = stock.getBody();
		return id;
		
	}
	
	public void registrarNotificacao() {
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject data = new JSONObject();
		data.put("host","localhost");
		data.put("port", "8081");
		HttpEntity<String> request = new HttpEntity<>(data.toString(),headers);
		restTemplate.postForObject(url + "/notification", request,String.class);
	}

	
}
