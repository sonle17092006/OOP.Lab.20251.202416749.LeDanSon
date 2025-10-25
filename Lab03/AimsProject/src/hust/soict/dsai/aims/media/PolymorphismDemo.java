package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Current date and time for documentation
        System.out.println("Demo executed at: 10:37 PM +07, Saturday, October 25, 2025");

        // Create a Cart for sorting
        Cart cart = new Cart();

        // Create some media: CD, DVD, Book
        CompactDisc cd = new CompactDisc("Pop", "Best Hits", 12.99f);
        cd.setId(1);
        cd.setDirector("Director X");
        cd.addTrack(new Track("Song 1", 180));
        cd.addTrack(new Track("Song 2", 240));

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        dvd1.setId(2);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        dvd2.setId(3);

        Book book = new Book();
        book.setId(4);
        book.setTitle("The Great Gatsby");
        book.setCategory("Fiction");
        book.setCost(15.99f);
        book.addAuthor("F. Scott Fitzgerald");
        book.setLength(500);

        // Add media to the cart
        cart.addMedia(cd, dvd1, dvd2, book);

        // Print unsorted cart
        System.out.println("\nUnsorted Cart:");
        cart.print();

        // Sort by title and print
        cart.sortByTitleCost();
        System.out.println("\nSorted by Title (then Cost):");
        cart.print();

        // Sort by cost and print
        cart.sortByCostTitle();
        System.out.println("\nSorted by Cost (then Title):");
        cart.print();
    }
}