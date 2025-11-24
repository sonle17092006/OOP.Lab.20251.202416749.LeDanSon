package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Wachowski", 136, 21.99f);

        System.out.println("=== Adding DVDs to Store ===");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd2);  // Try duplicate

        store.printStore();

        System.out.println("\n=== Removing DVDs from Store ===");
        store.removeDVD(dvd2);
        store.removeDVD(dvd3);
        store.removeDVD(new DigitalVideoDisc("Ghost DVD"));  // Not exist

        store.printStore();
    }
}