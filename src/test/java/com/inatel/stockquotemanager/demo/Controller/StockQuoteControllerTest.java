package com.inatel.stockquotemanager.demo.Controller;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class StockQuoteControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	StockService stockService;
	
	String id = "vale5";
	@BeforeEach
    public void beforeClass() {

       
    }
	@Test
	void testarCadastroDeStockQuotes() throws Exception {
		URI uri = new URI("/stockquotes");
		Map<String,String> quotes =new HashMap<>();
		JSONObject data = new JSONObject();
		quotes.put("2019-01-01", "10");
		JSONObject quote = new JSONObject(quotes);
		data.put("id",id);
		data.put("quotes",quote);
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(data.toString())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
	}
	@Test
	void testarListarTodosDeStockQuotes() throws Exception {
		URI uri = new URI("/stockquotes");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
	}
	@Test
	void testarListarumDeStockQuotes() throws Exception {
		URI uri = new URI("/stockquotes/petr4");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
	}
@Test
void testarSeNaoDeveriaCadastrarOsStockQuotes() throws Exception {
	URI uri = new URI("/stockquotes");
	Map<String,String> quotes =new HashMap<>();
	JSONObject data = new JSONObject();
	quotes.put("2019-01-01", "10");
	JSONObject quote = new JSONObject(quotes);
	data.put("id","88");
	data.put("quotes",quote);
	mockMvc
	.perform(MockMvcRequestBuilders
			.post(uri)
			.content(data.toString())
			.contentType(MediaType.APPLICATION_JSON))
	.andExpect(MockMvcResultMatchers
			.status()
			.is(404));
}
@Test
void testarNaoListarumDeStockQuotes() throws Exception {
	URI uri = new URI("/stockquotes/99");
	
	mockMvc.perform(get(uri))
    .andExpect(status().isNotFound());
}

}
