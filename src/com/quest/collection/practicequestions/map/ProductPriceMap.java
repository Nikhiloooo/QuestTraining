package com.quest.collection.practicequestions.map;

import java.util.HashMap;
import java.util.Map;

public class ProductPriceMap {
    public static void main(String[] args) {
        Map<String, Double> productPriceMap = new HashMap<String, Double>();
        productPriceMap.put("Apple", 11.0);
        productPriceMap.put("Banana", 20.0);
        productPriceMap.put("Orange", 32.0);
        productPriceMap.put("Grapes", 41.0);
        productPriceMap.put("Pineapple", 59.0);

        productPriceMap.put("Apple", 60.0);

        System.out.println("product price");
        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String highestPricedProduct = null;
        double highestPrice = 0;

        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            if (entry.getValue() > highestPrice) {
                highestPrice = entry.getValue();
                highestPricedProduct = entry.getKey();
            }
        }

        if(highestPricedProduct != null) {
            System.out.println("highest price is " + highestPricedProduct);

        }
        else {
            System.out.println("no product found");
        }

    }
}
