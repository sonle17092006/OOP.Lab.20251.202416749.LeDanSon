package hust.soict.dsai.aims.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 121, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);
      
        System.out.println("=== Testing addDigitalVideoDisc (single) ===");
        cart.addDigitalVideoDisc(dvd1);

        System.out.println("\n=== Testing addDigitalVideoDisc (two DVDs) ===");
        cart.addDigitalVideoDisc(dvd2, dvd3);
        

        System.out.println("\n=== Testing addDigitalVideoDisc (passing an array) ===");
        DigitalVideoDisc[] dvdArray = {dvd2, dvd3};
        cart.addDigitalVideoDisc(dvdArray);  // still works with varargs!

        System.out.println("\n=== Current Cart ===");
        cart.print();

        System.out.println("\n=== Removing a DVD ===");
        cart.removeDigitalVideoDisc(dvd3);

        System.out.println("\n=== Final Cart ===");
        cart.print();
    }
}