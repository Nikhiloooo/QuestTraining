package com.quest.oops.day10;

public abstract class StockAnalyzer {
     String stockName;
     String stockSymbol;
     int[] prices;

    public StockAnalyzer(String stockName, String stockSymbol, int[] prices) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.prices = prices;
}

    public abstract int findMaxPrice();
    public abstract int findMinPrice();
    public abstract double calculateAveragePrice();
    public abstract int[] findLongestIncreasingTrend();
    public abstract void displayAnalysis();
}