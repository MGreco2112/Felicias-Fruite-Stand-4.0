package Products;

//TODO switch access modifiers to Private and create abstract getters

public abstract class Product {
    protected String name;
    protected double retailPrice;
    protected double purchaseCost;

    public abstract String getName();

    public abstract double getRetailPrice();

    public abstract double getPurchaseCost();
}
