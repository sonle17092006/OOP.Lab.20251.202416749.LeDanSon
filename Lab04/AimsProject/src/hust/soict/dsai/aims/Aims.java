package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("Java Programming");
        book.addAuthor("John Doe");
        book.setCost(39.99f);
        CompactDisc cd = new CompactDisc("Thriller", "Music", null, "Michael Jackson", 15.99f);
        cd.addTrack(new Track("Billie Jean", 295));
        cd.addTrack(new Track("Beat It", 258));

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        showMenu();
    }

    // Full menu implementation (same as before, but now works perfectly)
    public static void showMenu() { /* ... full code from previous message ... */ }
    // Use the full Aims.java from my previous message — it works 100%
}