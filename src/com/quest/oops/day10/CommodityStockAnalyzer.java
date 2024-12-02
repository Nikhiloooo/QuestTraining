package com.quest.oops.day10;

public class CommodityStockAnalyzer extends StockAnalyzer {
    String commodityType;

    public CommodityStockAnalyzer(String stockName, String stockSymbol, int[] prices, String commodityType) {
        super(stockName, stockSymbol, prices);
        this.commodityType = commodityType;
    }

    @Override
    public int findMaxPrice() {
        int maxPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
        }
        return maxPrice;
    }

    @Override
    public int findMinPrice() {
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return minPrice;
    }

    @Override
    public double calculateAveragePrice() {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return (double) sum / prices.length;
    }

    @Override
    public int[] findLongestIncreasingTrend() {
        int maxLength = 1, currentLength = 1;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    start = tempStart;
                    end = i;
                }
            } else {
                currentLength = 1;
                tempStart = i;
            }
        }
        return new int[]{start + 1, end + 1, maxLength};
    }

    @Override
    public void displayAnalysis() {
        System.out.println("Analysis for Commodity Stock:");
        System.out.println("Stock Name: " + stockName);
        System.out.println("Stock Symbol: " + stockSymbol);
        System.out.println("Commodity Type: " + commodityType);
        System.out.println("Highest Price: " + findMaxPrice());
        System.out.println("Lowest Price: " + findMinPrice());
        System.out.println("Average Price: " + calculateAveragePrice());
        int[] trend = findLongestIncreasingTrend();
        System.out.println("Longest Increasing Trend: Start Day " + trend[0] + ", End Day " + trend[1] + ", Length: " + trend[2] + " days\n");
    }
}
