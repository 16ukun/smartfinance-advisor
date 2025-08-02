package com.smartFinanceAdvisor.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {
	@Id
	private String symbol;
	private String name;
	private String exchange;
	private String sector;
	private double latestPrice;
	private double peRatio;
	private double marketCap;

}
