package com.inatel.stockquotemanager.demo.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.stockquotemanager.demo.Model.Quotes;

public interface QuoteRepository  extends JpaRepository<Quotes, String>   {

	Page<Quotes> findByStock(String stock, Pageable paginacao);

	List<Quotes> findByStockId(String id);

}
