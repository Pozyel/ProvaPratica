package com.inatel.stockquotemanager.demo.Repository;



import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.stockquotemanager.demo.Model.Quotes;

@RunWith(SpringRunner.class)
@SpringBootTest
class QuoteRepositoryTest {

	@Autowired
	QuoteRepository quote;
	@Test
	void DeveriaRetornarUmaListaDeIds() {
		String id = "petr4";
	    List<Quotes> quotes = quote.findByStockId(id);
	    Assert.assertNotNull(quotes);
	}

}
