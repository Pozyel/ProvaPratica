package com.inatel.stockquotemanager.demo.Controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.stockquotemanager.demo.Controller.Dto.QuotesDto;
import com.inatel.stockquotemanager.demo.Controller.Dto.StockQuoteDto;
import com.inatel.stockquotemanager.demo.Controller.Form.QuoteForm;
import com.inatel.stockquotemanager.demo.Model.Quotes;
import com.inatel.stockquotemanager.demo.Model.Stock;
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
	public ResponseEntity<QuotesDto> cadastrar(@RequestBody @Valid QuoteForm form, UriComponentsBuilder uriBuilder) {
		Quotes quote = form.converter(stockRepository);
		String stockApi = StockService.get();
		System.out.println(stockApi);
		int indice = stockApi.indexOf(quote.getStock().getId());

		if (indice != -1) {

			quoteRepository.save(quote);
			URI uri = uriBuilder.path("/stockquotes/{id}").buildAndExpand(quote.getId()).toUri();
			return ResponseEntity.created(uri).body(new QuotesDto(quote));
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@GetMapping
	public Page<StockQuoteDto> lista(@RequestParam(required = false) String id,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (id == null) {
			Page<Stock> stock = stockRepository.findAll(paginacao);
			return StockQuoteDto.converter(stock);
		} else {
			Page<Stock> stock = stockRepository.findById(id, paginacao);
			return StockQuoteDto.converter(stock);
		}

	}
}
