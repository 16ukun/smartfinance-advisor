package com.smartFinanceAdvisor.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartFinanceAdvisor.backend.model.Stock;
import com.smartFinanceAdvisor.backend.repository.StockRepository;

// Business Logic Layer
@Service
public class StockServiceImplementation implements StockService {
	
	private final StockRepository stockRepository;
	
	@Autowired
	public StockServiceImplementation(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Override
	public Stock createStock(Stock stock) {
		Stock createdStock = this.stockRepository.save(stock);
		return createdStock;
	}

	@Override
	public List<Stock> getAllStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Stock> getStockBySymbol() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Stock updateStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStock() {
		// TODO Auto-generated method stub

	}

}
