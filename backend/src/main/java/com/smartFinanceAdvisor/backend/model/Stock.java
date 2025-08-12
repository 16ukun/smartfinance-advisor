package com.smartFinanceAdvisor.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
	@Id
	private String symbol;
	private String name;
	private String exchange;
	private String sector;
	private double latestPrice;
	private double peRatio;
	private double marketCap;

    public Stock() {
    }

    public Stock(String symbol, String name, String exchange, String sector,
                 double latestPrice, double peRatio, double marketCap) {
        this.symbol = symbol;
        this.name = name;
        this.exchange = exchange;
        this.sector = sector;
        this.latestPrice = latestPrice;
        this.peRatio = peRatio;
        this.marketCap = marketCap;
    }

    // Getters
    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getExchange() {
        return exchange;
    }

    public String getSector() {
        return sector;
    }

    public double getLatestPrice() {
        return latestPrice;
    }

    public double getPeRatio() {
        return peRatio;
    }

    public double getMarketCap() {
        return marketCap;
    }

    // Setters
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setLatestPrice(double latestPrice) {
        this.latestPrice = latestPrice;
    }

    public void setPeRatio(double peRatio) {
        this.peRatio = peRatio;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }

    // equals() and hashCode() (important for Hibernate identity checks)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // WHAT IS 'this' REFERING TO HERE?
        
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        return symbol != null ? symbol.equals(stock.symbol) : stock.symbol == null;
        // SHOULD THIS BE 'this.symbol'?
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }

    // toString()
    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", exchange='" + exchange + '\'' +
                ", sector='" + sector + '\'' +
                ", latestPrice=" + latestPrice +
                ", peRatio=" + peRatio +
                ", marketCap=" + marketCap +
                '}';
    }
}
