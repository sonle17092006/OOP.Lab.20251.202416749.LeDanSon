package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    public static void main(String[] args) {

        // ------------------- CREATE DVDs -------------------
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", 
                "Animation", "Ron Clements", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", 
                "Sci-Fi", "Christopher Nolan", 148, 22.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", 
                "Sci-Fi", "Wachowski", 136, 21.99f);

        // ------------------- TEST STORE -------------------
        Store store = new Store();

        System.out.println("=== Adding DVDs to Store ===");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.addDVD(dvd4);
        store.addDVD(dvd5);

        store.printStore();

        // ------------------- TEST CART -------------------
        Cart cart = new Cart();

        System.out.println("\n=== Testing Cart - add one by one ===");
        cart.addDigitalVideoDisc(dvd1);

        System.out.println("\n=== Testing Cart - add two at once ===");
        cart.addDigitalVideoDisc(dvd2, dvd3);


        System.out.println("\n=== Current Cart ===");
        cart.print();

        System.out.println("\n=== Removing one DVD from Cart ===");
        cart.removeDigitalVideoDisc(dvd3);

        System.out.println("\n=== Final Cart ===");
        cart.print();

        // Show total cost
        System.out.printf("\nTotal cost in cart: %.2f $\n", cart.totalCost());

        // Show that IDs are auto-generated
        System.out.println("\nDVD IDs (proof of static counter):");
        System.out.println(dvd1.getTitle() + " → ID: " + dvd1.getId());
        System.out.println(dvd2.getTitle() + " → ID: " + dvd2.getId());
        System.out.println(dvd3.getTitle() + " → ID: " + dvd3.getId());
        System.out.println(dvd4.getTitle() + " → ID: " + dvd4.getId());
        System.out.println(dvd5.getTitle() + " → ID: " + dvd5.getId());
    }
}