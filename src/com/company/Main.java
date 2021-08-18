package com.company;

public class Main {

    public static void main(String[] args) {
        //TODO Bug test error cases, add while loops to submenus, display store balance at end of console use
        Store mattsStore = new Store("Matt's Store", 1000);
        Console mattsConsole = new Console(mattsStore);
        mattsConsole.run();
        /*

         * Product Class
         * at least 2 child product classes

         * a Store class
         * has a store balance
         * stores a collection of the products it has available to purchase
         * can add products to the collection by spending its balance
         * can sell products which add to its balance and updates the collection of products
         * can throw away products

         * Console class
         * runs a user interface for the cashier. is given options to
         * add products to the store
         * throw away bad products
         * sell products to a client

         * The main focus of version 4.0 is to ensure Encapsulation in the system. use accurate access modifiers
         *
         *
         * Bonus challenge separate classes into packages as well.
         * Create a customer/purchase class and have the store keep track of purchase history.
         */
    }
}
