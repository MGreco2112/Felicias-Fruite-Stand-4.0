package com.company;

import Products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private String storeName;
    private double storeBalance;
    private Map<Product, Integer> products = new HashMap<>();
    public List<Product> inventory = new ArrayList<>();

    public Store(String storeName, double storeBalance) {
        this.storeName = storeName;
        this.storeBalance = storeBalance;
    }

    public String getStoreBalance() {
        return "Current balance: " + storeBalance;
    }

    public void getProducts() {
        for (Product key : products.keySet()) {
            System.out.println(key.getName() + ": " + products.get(key));
        }
    }

    public void addProduct(Product newProduct) {
        int count = 1;

        if (storeBalance >= newProduct.getPurchaseCost()) {
            storeBalance -= newProduct.getPurchaseCost();

            if (products.containsKey(newProduct)) {
                count = products.get(newProduct);
                count++;
                products.put(newProduct, count);
            } else {
                products.put(newProduct, count);
                inventory.add(newProduct);
            }

        } else {
            System.out.println(storeName + " has insufficient funds to purchase " + newProduct.getName());
        }
    }

    public void sellProduct(Product selProduct) {
        int count;

        if (products.containsKey(selProduct)) {
            count = products.get(selProduct);
            count--;
            if (count <= 0) {
                products.remove(selProduct);
                inventory.remove(selProduct);
            } else {
                products.put(selProduct, count);
            }
            storeBalance += selProduct.getRetailPrice();
            System.out.println("You have sold one " + selProduct.getName());

            if (products.get(selProduct) != null || !products.containsKey(selProduct)) {
                System.out.println(selProduct.getName() + ": " + products.get(selProduct) + " remaining.");
            } else {
                System.out.println(selProduct.getName() + ": 0 remaining.");
            }
        } else {
            System.out.println("You have no " + selProduct.getName() + "s to sell");
        }
    }

    public void sellProduct(Product selProduct, int qty) {
        int count;

        if (products.containsKey(selProduct) && products.get(selProduct) >= qty) {
            count = products.get(selProduct);
            count -= qty;
            if (count <= 0) {
                products.remove(selProduct);
                inventory.remove(selProduct);
            } else {
                products.put(selProduct, count);
            }
            storeBalance += selProduct.getRetailPrice();

            System.out.println("You have sold " + qty + " " + selProduct.getName() + "s");

            if (products.get(selProduct) != null || !products.containsKey(selProduct)) {
                System.out.println(selProduct.getName() + ": " + products.get(selProduct) + " remaining.");
            } else {
                System.out.println(selProduct.getName() + ": 0 remaining.");
            }
        } else {
            System.out.println("You do not have enough " + selProduct.getName() + "s to sell");
        }
    }

    public void discardProduct(Product tossProduct) {
        if (products.containsKey(tossProduct)) {
            System.out.println("All " + tossProduct.getName() + "s has been thrown out.");
            products.remove(tossProduct);
            inventory.remove(tossProduct);

        } else {
            System.out.println(storeName + " has no " + tossProduct.getName() + "s in stock.");
        }
    }

    public void discardProduct(Product tossProduct, int qty) {
        if (products.containsKey(tossProduct) && products.get(tossProduct) >= qty) {
            int count = products.get(tossProduct);
            count-= qty;

            if (count <= 0) {
                products.remove(tossProduct);
                inventory.remove(tossProduct);
                System.out.println("All " + tossProduct.getName() + " has been removed and is now out of stock.");
            } else {
                products.put(tossProduct, count);
                System.out.println(qty + " " + tossProduct.getName() + "s have been removed.\n" + tossProduct.getName() +
                        ": " + products.get(tossProduct) + " remaining.");
            }

        }
    }
}
