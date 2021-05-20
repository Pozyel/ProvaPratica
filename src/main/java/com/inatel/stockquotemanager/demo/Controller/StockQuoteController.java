package com.inatel.stockquotemanager.demo.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.stockquotemanager.demo.Controller.Dto.IdStockDto;
import com.inatel.stockquotemanager.demo.Controller.Dto.StockQuoteDto;
import com.inatel.stockquotemanager.demo.Controller.Form.StockQuoteForm;
import com.inatel.stockquotemanager.demo.Model.Quotes;
import com.inatel.stockquotemanager.demo.Repository.QuoteRepository;
import com.inatel.stockquotemanager.demo.Repository.StockRepository;

@RestController
@RequestMapping(path = "/stockquotes")
public class StockQuoteController {

	@Autowired
	private QuoteRepository quoteRepository;

	@Autowired
	private StockRepository stockRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<StockQuoteDto> cadastrar(@RequestBody @Valid StockQuoteForm form, UriComponentsBuilder uriBuilder) {
		List<Quotes> quote = form.ConverteMapa(stockRepository);
		String id = form.getId();
		String stockApi = StockService.get(id);
		

		if (stockApi != null) {

			quoteRepository.saveAll(quote);
			URI uri = uriBuilder.path("/stockquotes/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(uri).build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping
	public List<StockQuoteDto> listarTodos(@RequestParam(required = false) String id) {
		List<IdStockDto> stocks = Arrays.asList(StockService.getAll());
		List<StockQuoteDto> stockQuoteDto = new ArrayList<StockQuoteDto>();

		stocks.forEach(stock -> {
			List<Quotes> quotes = quoteRepository.findByStockId(stock.getId());
			System.out.println("teste"+quotes);
			stockQuoteDto.add(new StockQuoteDto(stock.getId(), quotes));
		});
		return stockQuoteDto;

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StockQuoteDto> ListarUm(@PathVariable String id){
		List<Quotes> quotes = quoteRepository.findByStockId(id);
		
		if(!quotes.isEmpty()) {
			return ResponseEntity.ok(new StockQuoteDto(id,quotes));
		}
		
		
		return ResponseEntity.notFound().build();
		
	}
}
