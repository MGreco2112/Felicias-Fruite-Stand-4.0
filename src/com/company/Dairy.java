package com.company;

public class Dairy extends Product{
    private final boolean isDairy = true;

    public Dairy(String name, double purchaseCost, double retailPrice) {
        this.name = name;
        this.purchaseCost = purchaseCost;
        this.retailPrice = retailPrice;
    }
}
