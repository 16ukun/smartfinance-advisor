package com.smartFinanceAdvisor.backend.service;

import java.util.List;
import java.util.Optional;

import com.smartFinanceAdvisor.backend.model.Stock;

public interface StockService {

	// I can remove the 'public' and 'abstract' since they are by default in interfaces
	public abstract Stock createStock(Stock stock);
	public abstract List<Stock> getAllStock();
	public abstract Optional<Stock> getStockBySymbol();
	public abstract Stock updateStock();
	public abstract void deleteStock();
}
