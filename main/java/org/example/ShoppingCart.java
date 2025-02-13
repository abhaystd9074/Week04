package org.example;

import java.util.*;
import java.lang.*;

public class ShoppingCart {
    private HashMap<String, Double> productPrices;
    private LinkedHashMap<String, Integer> cartOrder;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartOrder = new LinkedHashMap<>();
    }

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, cartOrder.getOrDefault(product, 0) + 1);
    }

    public void displayCart() {
        System.out.println("Items in Cart:");
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> Quantity: " + entry.getValue() + ", Price: " + productPrices.get(entry.getKey()));
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedProducts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedProducts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Products Sorted by Price:");
        for (Map.Entry<Double, String> entry : sortedProducts.entrySet()) {
            System.out.println(entry.getValue() + " -> Price: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Orange", 1.2);
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Grapes", 2.0);

        cart.displayCart();
        cart.displaySortedByPrice();
    }
}

