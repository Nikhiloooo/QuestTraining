package com.quest.practice_vars;

import java.util.Scanner;

public class AdvancedSalesReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        //initializing the variable
        int numOfProducts = getNumOfProducts(sc);
        String[] products = new String[numOfProducts];
        double[][] inventory = new double[numOfProducts][2];// inventory[i][0] = stock, inventory[i][1] = price
        int[] quantitySold = new int[numOfProducts];



        for (int i = 0; i < numOfProducts; i++) {

            //to get the name of each product
            System.out.println("Enter the Products " + (i + 1));
            products[i] = sc.nextLine();

            inventory[i][0] = getStockQuantity(sc, products[i]);
            inventory[i][1]=getProductPrice(sc, products[i]);
            quantitySold[i]=getQuantitySold(sc,products[i],inventory[i][0]);

        }
        generateSalesReport(products, inventory, quantitySold);
        checkInventoryShortage(products, inventory, quantitySold);
        restockInventory(sc, products, inventory);
        generateSalesSummaryByPriceRange(sc,products,inventory,quantitySold);
        trackOutOfStockProducts(products, inventory);
    }


//to get the number of products
    private static int getNumOfProducts(Scanner sc) {
        int getNumOfProducts;
        while (true) {
            //getting number of Products from user
            System.out.print("Enter the number of Products: ");

            //handle if user enters other than integer
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                sc.next();

            }
            getNumOfProducts = sc.nextInt();
            sc.nextLine();
            if (getNumOfProducts >= 1 && getNumOfProducts <= 100) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            }
        }
        return getNumOfProducts;
    }

//get the quatity in staock for each product in inventory[i][0]
    private static int getStockQuantity(Scanner sc, String product) {
        int stock;
        while (true) {
            System.out.print("Enter the stock quantity for " + product + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                sc.next();
            }
            stock = sc.nextInt();
            sc.nextLine();
            if (stock >= 0) break;
            else System.out.println("Invalid input. Stock quantity must be non-negative.");
        }
        return stock;
    }

//getting the price of each units in inventory[i][1]
    private static double getProductPrice(Scanner sc, String product) {
        double price;
        while (true) {
            System.out.print("Enter the price per unit for " + product + ": ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a positive integer for the price.");
                sc.next();
            }
             price = sc.nextDouble();
            sc.nextLine(); // consume newline
            if (price > 0) break;
            else System.out.println("Invalid input. Price must be greater than zero.");
        }
        return price;
    }


    //getting the quantity sold for each product
    private static int getQuantitySold(Scanner sc, String product, double stock) {
        int quantity;
        while (true) {
            System.out.print("Enter the quantity sold for " + product + " : ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a non-negative integer up to the stock limit.");
                sc.next();
            }
            quantity = sc.nextInt();
            sc.nextLine();
            if (quantity >= 0 ) break;
            else System.out.println("Invalid input. Please enter a non-negative integer up to the stock limit.");
        }
        return quantity;
    }



    // Task 1: Generate Sales Report
    private static void generateSalesReport(String[] products, double[][] inventory, int[] quantitySold) {
        double totalRevenue = 0;
        System.out.println("Task 1: Sales Report:");
        for (int i = 0; i < products.length; i++) {
            double revenue = quantitySold[i] * inventory[i][1]; // Calculate revenue for sold quantity
            System.out.println(products[i] + " sold " + quantitySold[i] + " units, Revenue: $" + revenue);
            totalRevenue += revenue;
        }
        System.out.println("Total revenue: $" + totalRevenue);
    }



    // Task 2: Inventory Shortage Check
    private static void checkInventoryShortage(String[] products, double[][] inventory, int[] quantitySold) {
        System.out.println("\nTask 2: Inventory Shortage Check:");
        for (int i = 0; i < products.length; i++) {
            if (quantitySold[i] > inventory[i][0]) {
                System.out.println("Warning: Insufficient stock for " + products[i] + ". Sold " + quantitySold[i] + " units, but only " + inventory[i][0] + " units were available.");
            }
            else{
                System.out.println("no shortage");
            }
        }
    }


    // Task 3: Restock Inventory
    private static void restockInventory(Scanner sc, String[] products, double[][] inventory) {
        System.out.print("\nTask 3: Restock Inventory:\nEnter the product to restock: ");
        String restockProduct = sc.nextLine();
        int restockAmount;
        while (true) {
            System.out.print("Enter the number of units to restock: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                sc.next();
            }
            restockAmount = sc.nextInt();
            sc.nextLine();
            if (restockAmount >= 0) break;
            else System.out.println("Invalid input. restock quantity must be non-negative.");
        }

        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(restockProduct)) {
                inventory[i][0] += restockAmount; // Update stock
                System.out.println("Restocking " + restockProduct + " with " + restockAmount + " units.");
                System.out.println("Updated stock for " + restockProduct + ": " + inventory[i][0] + " units.");
                return;
            }
        }
        System.out.println("Product not found.");
    }


    // Task 4: Sales Summary Based on Price Range
    private static void generateSalesSummaryByPriceRange(Scanner sc, String[] products, double[][] inventory, int[] quantitySold) {
        System.out.println("\nTask 4: Sales Summary Based on Prince Range: ");
        double minPrice;
        double maxPrice;
        while (true) {
            System.out.print("Enter the minimum price");

            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                sc.next();
            }
            minPrice = sc.nextDouble();
            sc.nextLine();
            break;
        }

        while (true) {
            System.out.print("Enter the maximum  price");

            while (!sc.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                sc.next();
            }
            maxPrice = sc.nextDouble();
            sc.nextLine();
            break;
        }

        System.out.println("Products in the range " + minPrice + " to " + maxPrice + " :");
        {
            for (int i = 0; i < products.length; i++) {
                double price = inventory[i][1];
                if (price >= minPrice && price <= maxPrice) {
                    double revenue = Math.min(quantitySold[i], inventory[i][0]) * price;
                    System.out.println(products[i] + " :revenue = " + revenue);
                }
            }

        }

    }


    // Task 5: Track Out-of-Stock Products
        private static void trackOutOfStockProducts(String[] products,double[][] inventory){
            System.out.println("\nTask 5:  out of Stock Products:");
            for(int i = 0; i < products.length; i++) {
                if(inventory[i][0]==0)
                {
                    System.out.println(products[i]+" is out of stock");
                }
                else{
                    System.out.println("currently no out Of Stock reported");
                }
            }

        }





}
