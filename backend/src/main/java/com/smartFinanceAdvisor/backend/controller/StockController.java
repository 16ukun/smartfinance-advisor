package com.smartFinanceAdvisor.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartFinanceAdvisor.backend.model.Stock;
import com.smartFinanceAdvisor.backend.service.StockServiceImplementation;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

	private StockServiceImplementation stockServiceImplementation;
	
	@Autowired
	public StockController(StockServiceImplementation stockServiceImplementation) {
		this.stockServiceImplementation = stockServiceImplementation;
	}
	
	@PostMapping
	public ResponseEntity<Stock> createStock(@Valid @RequestBody Stock stock) {
		Stock createdStock = this.stockServiceImplementation.createStock(stock);
		ResponseEntity<Stock> stockResponseEntity = ResponseEntity.ok().body(createdStock);
		return stockResponseEntity;
	}
	
	@GetMapping
	public ResponseEntity<List<Stock>> getAllStocks(){
		List<Stock> listOfStocks = this.stockServiceImplementation.getAllStock();
		ResponseEntity<List<Stock>> stockResponseEntityList = ResponseEntity.ok(listOfStocks);
		return stockResponseEntityList;
	}
	
	@GetMapping("/{symbol}")
	public ResponseEntity<Stock> getStockBySymbol(@PathVariable String symbol) {
	    Optional<Stock> optionalStock = stockServiceImplementation.getStockBySymbol(symbol);

	    if (optionalStock.isPresent()) {
	        Stock stock = optionalStock.get();
	        return ResponseEntity.ok(stock);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
    @PutMapping("/{symbol}")
    public ResponseEntity<Stock> updateStock(@PathVariable String symbol, @Valid @RequestBody Stock stock) {
        return ResponseEntity.ok(stockServiceImplementation.updateStock(symbol, stock));
    }
	
    @DeleteMapping("/{symbol}")
    public ResponseEntity<Void> deleteStock(@PathVariable String symbol) {
        stockServiceImplementation.deleteStock(symbol);
        return ResponseEntity.noContent().build();
    }

	
	// Note ****
	//	ResponseEntity.ok(listOfStocks); 
	//	IS EQUIVALENT/SHORTCUT TO:
	//	ResponseEntity.ok().body(listOfStocks);
}
