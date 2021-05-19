package com.inatel.stockquotemanager.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.stockquotemanager.demo.Model.Stock;

public interface StockRepository extends JpaRepository<Stock,String> {

	Page<Stock> findById(String id, Pageable paginacao);

	

}
