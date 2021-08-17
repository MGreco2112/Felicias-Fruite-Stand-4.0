package com.company;

public class Produce extends Product{
    private final boolean isProduce = true;

    public Produce(String name, double purchaseCost, double retailPrice) {
        this.name = name;
        this.purchaseCost = purchaseCost;
        this.retailPrice = retailPrice;
    }
}
