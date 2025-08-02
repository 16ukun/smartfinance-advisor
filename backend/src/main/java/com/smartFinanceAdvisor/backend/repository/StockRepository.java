package com.smartFinanceAdvisor.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartFinanceAdvisor.backend.model.Stock;

// Persistence/Data-Access Layer
@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
