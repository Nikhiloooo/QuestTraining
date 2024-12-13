package com.quest.practicecase.case2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductInventoryManagement {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1000.0, 20),
                new Product(2, "Mouse", 50.0, 100),
                new Product(3, "Keyboard", 70.0, 50),
                new Product(4, "Monitor", 300.0, 30)
        );

// Compute total inventory value
        double totalInventory = products.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
        System.out.println("Total inventory value: " + totalInventory);


        //  Find the top 3 most expensive products
        List<String> expensive =products.stream()
                .sorted((p1,p2)->Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(3)
                .map(product -> product.getProductName())
                .collect(Collectors.toList());
        System.out.println("Top 3 most expensive products: " +expensive);

//        Collect all products into a Map
        Map<String,Double> newMapping=products.stream()
                .collect(Collectors.toMap(Product::getProductName, Product::getPrice));
        System.out.println("Product map: " +newMapping);

    }
}
