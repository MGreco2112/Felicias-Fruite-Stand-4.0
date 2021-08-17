package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Console {
    private Store store;
    private final Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();

    public Console(Store store) {
        this.store = store;
    }

    //TODO Add field which holds instanciated products to load into method
    public void cashierOptions() {

        String choice;

        do {
            System.out.println("Which option will you select?\n" +
                    "(a)dd products to store\n" +
                    "(t)oss bad products\n" +
                    "(s)ell product");

            choice = scanner.nextLine();
        } while (!choice.toLowerCase(Locale.ROOT).equals("a") &&
        !choice.equals("t") && !choice.equals("s"));

        switch (choice.toLowerCase(Locale.ROOT)) {
            case "a" :
                System.out.println("Which Product would you like to add to the store?");

                String productSelection = scanner.nextLine();

                for (Product product : products) {
                    if (product.name.equals(productSelection)) {
                        store.addProduct(product);
                    }
                }
                break;

            case "t" :
                System.out.println("Which product would you like to toss?");

                String toToss = scanner.nextLine();

                for (Product product : store.inventory) {
                    if (product.name.equals(toToss)) {
                        System.out.println("How many " + product.name + "s would you like to toss?");

                        String pick = scanner.nextLine();

                        if (Integer.parseInt(pick) > 1) {
                            store.discardProduct(product, Integer.parseInt(pick));
                        } else {
                            store.discardProduct(product);
                        }
                    }
                }

                break;

            case "s" :

        }



    }

    private void addProducts() {

    }

    private void tossProducts() {

    }

    private void sellProducts() {

    }

}
