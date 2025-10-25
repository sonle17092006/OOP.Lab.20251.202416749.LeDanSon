package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        // Initialize store with some sample media
        initializeStore();

        // Current date and time for documentation
        System.out.println("AIMS Application started at: 10:39 PM +07, Saturday, October 25, 2025");

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0-3.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initializeStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        Book book = new Book();
        book.setTitle("The Great Gatsby");
        book.setCategory("Fiction");
        book.setCost(15.99f);
        book.addAuthor("F. Scott Fitzgerald");
        book.setLength(500);
        CompactDisc cd = new CompactDisc("Pop", "Best Hits", 12.99f);
        cd.setDirector("Director X");
        cd.addTrack(new Track("Song 1", 180));
        cd.addTrack(new Track("Song 2", 240));

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void viewStore(Scanner scanner) {
        store.printItems(); // Assuming a method to print all items (added below)
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter media title to see details: ");
                    String title = scanner.nextLine();
                    Media media = findMediaByTitle(store.getItemsInStore(), title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsMenu(scanner, media);
                    } else {
                        System.out.println("No media found with title: " + title);
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    title = scanner.nextLine();
                    media = findMediaByTitle(store.getItemsInStore(), title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Number of items in cart: " + cart.getItemCount());
                    } else {
                        System.out.println("No media found with title: " + title);
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    title = scanner.nextLine();
                    media = findMediaByTitle(store.getItemsInStore(), title);
                    if (media != null && media instanceof Playable) {
                        ((Playable) media).play();
                    } else if (media == null) {
                        System.out.println("No media found with title: " + title);
                    } else {
                        System.out.println("Media is not playable.");
                    }
                    break;
                case 4:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0-4.");
            }
        } while (choice != 0);
    }

    private static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    private static void mediaDetailsMenu(Scanner scanner, Media media) {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Number of items in cart: " + cart.getItemCount());
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media type cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0-2.");
            }
        } while (choice != 0);
    }

    private static void updateStore(Scanner scanner) {
        int choice;
        do {
            System.out.println("Update Store: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to store");
            System.out.println("2. Remove a media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter media title to add: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    Media media = new DigitalVideoDisc(category, title, cost); // Simplified for demo
                    store.addMedia(media);
                    break;
                case 2:
                    System.out.print("Enter media title to remove: ");
                    title = scanner.nextLine();
                    media = findMediaByTitle(store.getItemsInStore(), title);
                    if (media != null) {
                        store.removeMedia(media);
                    } else {
                        System.out.println("No media found with title: " + title);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0-2.");
            }
        } while (choice != 0);
    }

    private static void seeCurrentCart(Scanner scanner) {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    filterMediaInCart(scanner);
                    break;
                case 2:
                    sortMediaInCart(scanner);
                    break;
                case 3:
                    System.out.print("Enter media title to remove: ");
                    String title = scanner.nextLine();
                    Media media = findMediaByTitle(cart.getItemsOrdered(), title);
                    if (media != null) {
                        cart.removeMedia(media);
                    } else {
                        System.out.println("No media found with title: " + title);
                    }
                    break;
                case 4:
                    System.out.print("Enter media ID to play: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cart.playMedia(id);
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0-5.");
            }
        } while (choice != 0);
    }

    private static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void filterMediaInCart(Scanner scanner) {
        System.out.println("Filter Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter ID to filter: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                cart.searchById(id);
                break;
            case 2:
                System.out.print("Enter title to filter: ");
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 0-2.");
        }
    }

    private static void sortMediaInCart(Scanner scanner) {
        System.out.println("Sort Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                cart.sortByTitleCost();
                cart.print();
                break;
            case 2:
                cart.sortByCostTitle();
                cart.print();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 0-2.");
        }
    }

    private static void placeOrder() {
        System.out.println("Order has been created.");
        cart = new Cart(); // Empty the current cart
    }

    private static Media findMediaByTitle(List<Media> mediaList, String title) {
        for (Media media : mediaList) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
}

// Extensions to Store and Cart classes for additional methods
class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (media != null && !itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Media added to the store: " + media.getTitle());
        } else {
            System.out.println("Media is already in the store or is null: " + (media != null ? media.getTitle() : "null"));
        }
    }

    public void removeMedia(Media media) {
        if (media != null && itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Media removed from the store: " + media.getTitle());
        } else {
            System.out.println("Media not found in the store or is null: " + (media != null ? media.getTitle() : "null"));
        }
    }

    public void printItems() {
        System.out.println("Store Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
    }

    public List<Media> getItemsInStore() {
        return new ArrayList<Media>(itemsInStore);
    }
}

class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (media != null && !itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added: " + media.getTitle());
        } else {
            System.out.println("The media is already in the cart or is null: " + (media != null ? media.getTitle() : "null"));
        }
    }

    public void removeMedia(Media media) {
        if (media != null && itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed: " + media.getTitle());
        } else {
            System.out.println("The media is not in the cart or is null: " + (media != null ? media.getTitle() : "null"));
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found: " + media.toString());
                return;
            }
        }
        System.out.println("No match found for ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }

    public void playMedia(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id && media instanceof Playable) {
                ((Playable) media).play();
                return;
            }
        }
        System.out.println("No playable media found with ID: " + id);
    }

    public int getItemCount() {
        return itemsOrdered.size();
    }

    public List<Media> getItemsOrdered() {
        return new ArrayList<Media>(itemsOrdered);
    }
}