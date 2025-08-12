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
		return stockRepository.findAll();
	}

	@Override
	public Optional<Stock> getStockBySymbol(String symbol) {
		 return stockRepository.findById(symbol);
	}

    @Override
    public Stock updateStock(String symbol, Stock updatedStock) {
        Optional<Stock> optionalStock = stockRepository.findById(symbol);

        if (optionalStock.isEmpty()) {
            throw new RuntimeException("Stock not found");
        }

        Stock existing = optionalStock.get();
        
        existing.setName(updatedStock.getName());
        existing.setExchange(updatedStock.getExchange());
        existing.setSector(updatedStock.getSector());
        existing.setLatestPrice(updatedStock.getLatestPrice());
        existing.setPeRatio(updatedStock.getPeRatio());
        existing.setMarketCap(updatedStock.getMarketCap());
        
        return stockRepository.save(existing);
    }

    @Override
    public void deleteStock(String symbol) {
        stockRepository.deleteById(symbol);
    }

}
