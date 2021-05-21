package com.inatel.stockquotemanager.demo.Repository;



import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.stockquotemanager.demo.Model.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
class StockRepositoryTest {

	@Autowired
	StockRepository stockRepository;
	@Test
	void DeveRetornarOIdDoStock() {
		String id = "petr4";
		
		Page<Stock> stock = stockRepository.findById(id, null);
	    Assert.assertNotNull(stock);
	}


}
