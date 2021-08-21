package Products;


import Products.Product;

//TODO create setters to set values to fields
public class Dairy extends Product {
    private final boolean isDairy = true;

    public Dairy(String name, double purchaseCost, double retailPrice) {
        this.name = name;
        this.purchaseCost = purchaseCost;
        this.retailPrice = retailPrice;
    }

    public String getName() {
        return name;
    }

    public double getPurchaseCost() {
        return purchaseCost;
    }

    public double getRetailPrice() {
        return retailPrice;
    }
}
