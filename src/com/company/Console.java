package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Console {
    private Store store;
    private final Scanner scanner = new Scanner(System.in);
    private List<Product> products = new ArrayList<>();
    private boolean isActive = true;

    public Console(Store store) {
        this.store = store;
        loadProducts();
    }

    public void run() {
        while (isActive) {
            cashierOptions();
        }
    }

    private void loadProducts() {
        products.add(new Produce("Beet", 0.99, 2.50));
        products.add(new Produce("Lettuce", .20, .99));
        products.add(new Dairy("Milk", 1.25, 2.50));
        products.add(new Dairy("Butter", .25, .99));
    }


    private void cashierOptions() {

        String choice;

        do {
            System.out.println("Which option will you select?\n" +
                    "(a)dd products to store\n" +
                    "(t)oss bad products\n" +
                    "(s)ell product\n" +
                    "(e)xit");

            choice = scanner.nextLine();
        } while (!choice.toLowerCase(Locale.ROOT).equals("a") &&
        !choice.equals("t") && !choice.equals("s") && !choice.equals("e"));

        switch (choice.toLowerCase(Locale.ROOT)) {
            case "a" :

                addProducts();

                break;

            case "t" :

                tossProducts();

                break;

            case "s" :

                sellProducts();

                break;

            case "e" :
                System.out.println("Logging Off...");
                isActive = false;
                break;

            default :
                System.out.println("Invalid entry");

        }



    }

    private void addProducts() {
        System.out.println("Which Product would you like to add to the store?");

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+ 1) + ") " + products.get(i).name);
        }

        String productSelection = scanner.nextLine();

        if (Integer.parseInt(productSelection) - 1 > -1 && Integer.parseInt(productSelection) - 1 <= products.size()) {
            store.addProduct(products.get(Integer.parseInt(productSelection)- 1));
        }
    }

    private void tossProducts() {
        System.out.println("Which product would you like to toss?");

        String toToss;
        do {
            for (int i = 0; i < store.inventory.size(); i++) {
                System.out.println((i + 1) + ") " + store.inventory.get(i).name);
            }

            toToss = scanner.nextLine();
        } while (Integer.parseInt(toToss) - 1 <= -1 && Integer.parseInt(toToss) - 1 > store.inventory.size());

        System.out.println("How many " + store.inventory.get(Integer.parseInt(toToss)).name + " will you toss?");
        store.getProducts();

        String tossNum = scanner.nextLine();

        if (Integer.parseInt(tossNum) > 1) {
            store.discardProduct(store.inventory.get(Integer.parseInt(toToss)-1), Integer.parseInt(tossNum));
        } else {
            store.discardProduct(store.inventory.get(Integer.parseInt(toToss)-1));
        }



    }

    private void sellProducts() {
        String sellPick;

        do {
            System.out.println("Which Product will you sell?");

            for (int i = 0; i < store.inventory.size(); i++) {
                System.out.println((i + 1) + ") " + store.inventory.get(i).name);
            }

            System.out.println("Enter the number next to the Product name");

            sellPick = scanner.nextLine();

        } while (Integer.parseInt(sellPick) - 1 <= -1 && Integer.parseInt(sellPick) - 1 >= store.inventory.size() - 1);

        System.out.println("How many Products are being sold?");
        store.getProducts();

        String sellNum = scanner.nextLine();

        if (Integer.parseInt(sellNum) > 1) {
            store.sellProduct(store.inventory.get(Integer.parseInt(sellPick) - 1), Integer.parseInt(sellNum));
        } else {
            store.sellProduct(store.inventory.get(Integer.parseInt(sellPick)- 1));
        }

    }

}
