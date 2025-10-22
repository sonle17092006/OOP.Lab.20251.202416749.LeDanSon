package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100]; // Assuming a max capacity of 100 DVDs
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore >= 100) {
            System.out.println("The store is full. Cannot add more DVDs.");
            return;
        }
        itemsInStore[qtyInStore] = dvd;
        qtyInStore++;
        System.out.println("DVD has been added to the store: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD has been removed from the store: " + dvd.getTitle());
                return;
            }
        }
        System.out.println("DVD not found in the store: " + dvd.getTitle());
    }
}