package Products;


import Products.Product;

//TODO assign values to fields using setters
public class Produce extends Product {
    private final boolean isProduce = true;

    public Produce(String name, double purchaseCost, double retailPrice) {
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
