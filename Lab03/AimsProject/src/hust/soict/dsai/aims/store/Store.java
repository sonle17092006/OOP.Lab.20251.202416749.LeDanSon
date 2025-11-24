package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_IN_STORE = 1000;  // or any reasonable number
    private DigitalVideoDisc[] itemsInStore;
    private int qtyStored = 0;

    // Constructor
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
    }

    // Method: Add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyStored >= MAX_NUMBERS_IN_STORE) {
            System.out.println("Store is full. Cannot add more DVDs.");
            return;
        }
        
        // Check if the DVD is already in the store (optional but good practice)
        for (int i = 0; i < qtyStored; i++) {
            if (itemsInStore[i].equals(dvd)) {
                System.out.println("DVD \"" + dvd.getTitle() + "\" is already in the store.");
                return;
            }
        }

        itemsInStore[qtyStored] = dvd;
        qtyStored++;
        System.out.println("DVD \"" + dvd.getTitle() + "\" has been added to the store.");
    }

    // Method: Remove a DVD from the store
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyStored; i++) {
            if (itemsInStore[i].equals(dvd)) {
                found = true;
                // Shift all elements to the left
                for (int j = i; j < qtyStored - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[--qtyStored] = null;  // clear last position
                System.out.println("DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }

    // Optional: Print all DVDs in store (very useful for testing)
    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        System.out.println("Items in store (" + qtyStored + "):");
        if (qtyStored == 0) {
            System.out.println("  [Empty]");
        } else {
            for (int i = 0; i < qtyStored; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("*****************************************************");
    }
}