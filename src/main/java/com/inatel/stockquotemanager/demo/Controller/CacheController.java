package com.inatel.stockquotemanager.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	public CacheController(StockService stockService) {
		stockService.registrarNotificacao();
	}
	
	@DeleteMapping
	@Transactional
	@Caching(evict = { @CacheEvict(value = "stock",allEntries=true),
			 @CacheEvict(value = "stocklista", allEntries = true)})
	public ResponseEntity<?> cleanCache(){
		return ResponseEntity.status(204).build();
		
	}
}
