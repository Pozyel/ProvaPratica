package com.inatel.stockquotemanager.demo.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.stockquotemanager.demo.Model.Quotes;

public interface QuoteRepository  extends JpaRepository<Quotes, String>   {

	

	List<Quotes> findByStockId(String id);

}
