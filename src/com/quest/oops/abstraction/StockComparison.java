package com.quest.oops.abstraction;
import java.util.Scanner;
public class StockComparison {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Equity Stock
        System.out.println("Enter details for Equity Stock:");
        System.out.print("Stock Name: ");
        String equityName = sc.nextLine();
        System.out.print("Stock Symbol: ");
        String equitySymbol = sc.nextLine();
        System.out.print("Sector: ");
        String sector = sc.nextLine();
        int n = getNumOfDays(sc);


        int[] equityPrices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            equityPrices[i] = sc.nextInt();
        }

        // Input for Commodity Stock
        sc.nextLine(); // Consume newline
        System.out.println("\nEnter details for Commodity Stock:");
        System.out.print("Stock Name: ");
        String commodityName = sc.nextLine();
        System.out.print("Stock Symbol: ");
        String commoditySymbol = sc.nextLine();
        System.out.print("Commodity Type: ");
        String commodityType = sc.nextLine();
         n = getNumOfDays(sc);

        int[] commodityPrices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            commodityPrices[i] = sc.nextInt();
        }

        // Create objects for stocks
        StockAnalyzer equityStock = new EquityStockAnalyzer(equityName, equitySymbol, equityPrices, sector);
        StockAnalyzer commodityStock = new CommodityStockAnalyzer(commodityName, commoditySymbol, commodityPrices, commodityType);

        // Perform analysis and display
        equityStock.displayAnalysis();
        commodityStock.displayAnalysis();

        // Compare average prices
        double equityAvgPrice = equityStock.calculateAveragePrice();
        double commodityAvgPrice = commodityStock.calculateAveragePrice();
        if (equityAvgPrice > commodityAvgPrice) {
            System.out.println("Stock with Highest Average Price: Equity Stock - " + equityName + " with Average Price: " + equityAvgPrice);
        } else if (commodityAvgPrice > equityAvgPrice) {
            System.out.println("Stock with Highest Average Price: Commodity Stock - " + commodityName + " with Average Price: " + commodityAvgPrice);
        } else {
            System.out.println("Both stocks have the same average price of " + equityAvgPrice);
        }

        // Compare longest increasing trends
        int[] equityTrend = equityStock.findLongestIncreasingTrend();
        int[] commodityTrend = commodityStock.findLongestIncreasingTrend();
        if (equityTrend[2] > commodityTrend[2]) {
            System.out.println("Stock with Longest Increasing Trend: Equity Stock - " + equityName + " with a trend length of " + equityTrend[2] + " days.");
        } else if (commodityTrend[2] > equityTrend[2]) {
            System.out.println("Stock with Longest Increasing Trend: Commodity Stock - " + commodityName + " with a trend length of " + commodityTrend[2] + " days.");
        } else {
            System.out.println("Both stocks have the same longest increasing trend length of " + equityTrend[2] + " days.");
        }
    }




    private static int getNumOfDays(Scanner sc) {
        int n;
        while (true) {

            System.out.print("Number of days: ");

            //handle if user enters other than integer
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input.");
                sc.next();

            }
            n = sc.nextInt();
            sc.nextLine();

            if (n>0) {
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
        return n;
    }
}
