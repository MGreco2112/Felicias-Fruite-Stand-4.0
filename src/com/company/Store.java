package com.company;

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

    public void getProducts() {
        for (Product key : products.keySet()) {
            System.out.println(key.name + ": " + products.get(key));
        }
    }

    public void addProduct(Product newProduct) {
        int count = 1;

        if (storeBalance >= newProduct.purchaseCost) {
            storeBalance -= newProduct.purchaseCost;

            if (products.containsKey(newProduct)) {
                count = products.get(newProduct);
                count++;
                products.put(newProduct, count);
            } else {
                products.put(newProduct, count);
                inventory.add(newProduct);
            }

        } else {
            System.out.println(storeName + " has insufficient funds to purchase " + newProduct.name);
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
            storeBalance += selProduct.retailPrice;
            System.out.println("You have sold a " + selProduct.name + "\n" + selProduct.name + ": " + products.get(selProduct) + " remaining.");
        } else {
            System.out.println("You have no " + selProduct.name + "s to sell");
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
            storeBalance += selProduct.retailPrice;

            System.out.println("You have sold " + qty + " " + selProduct.name + "s");

            if (products.get(selProduct) != null) {
                System.out.println(selProduct.name + ": " + products.get(selProduct) + " remaining.");
            } else {
                System.out.println(selProduct.name + ": 0 remaining.");
            }
        } else {
            System.out.println("You do not have enough " + selProduct.name + "s to sell");
        }
    }

    public void discardProduct(Product tossProduct) {
        if (products.containsKey(tossProduct)) {
            System.out.println("All " + tossProduct.name + "s has been thrown out.");
            products.remove(tossProduct);

        } else {
            System.out.println(storeName + " has no " + tossProduct.name + "s in stock.");
        }
    }

    public void discardProduct(Product tossProduct, int qty) {
        if (products.containsKey(tossProduct) && products.get(tossProduct) >= qty) {
            int count = products.get(tossProduct);
            count-= qty;

            if (count <= 0) {
                products.remove(tossProduct);
                System.out.println("All " + tossProduct.name + " has been removed and is now out of stock.");
            } else {
                products.put(tossProduct, count);
                System.out.println(qty + " " + tossProduct.name + "s have been removed.\n" + tossProduct.name + ": " + products.get(tossProduct) + " remaining.");
            }

        }
    }
}
