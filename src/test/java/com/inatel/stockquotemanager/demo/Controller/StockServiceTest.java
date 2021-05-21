package com.inatel.stockquotemanager.demo.Controller;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.stockquotemanager.demo.Controller.Dto.IdStockDto;

@RunWith(SpringRunner.class)
@SpringBootTest

class StockServiceTest {

	@Test
	public void testaSeRecebeuUmaIdDaApiExterna() {
		String id = StockService.get("petr4");
		Assert.assertNotNull(id);
		
	}
	@Test
	public void testaSeNaoRecebeuUmaIdDaApiExterna() {
		String id = StockService.get("petr99");
		Assert.assertNull(id);
		
	}
	@Test
	public void testaSeRecebeuUmaListaDeIdsDaApiExterna() {
		List<IdStockDto> stocks = Arrays.asList(StockService.getAll());
		Assert.assertNotNull(stocks);
		
	}
	@Test
	public void testaSeNaoRecebeuUmaListaDeIdsDaApiExterna() {
		String id = StockService.get("petr99");
		Assert.assertNull(id);
		
	}
	
	

}
