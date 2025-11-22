package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import java.util.List;
import hust.soict.dsai.aims.store.Store;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm sẵn vài media để test
        store.addMedia(new Book("Harry Potter", "Fantasy", 29.99f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f));
        store.addMedia(new CompactDisc("1989", "Pop", "Taylor Swift", 50f, "Taylor Swift"));

        while (true) {
            showMenu();
            int choice = getChoice(0, 4);

            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> seeCurrentCart();
                case 0 -> {
                    System.out.println("Goodbye! See you again!");
                    scanner.close();
                    return;
                }
            }
        }
    }

    // ==================== MAIN MENU ====================
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // ==================== VIEW STORE ====================
    public static void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = getChoice(0, 4);

            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addToCart();
                case 3 -> playMedia();
                case 4 -> seeCurrentCart();
                case 0 -> { return; }
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    // ==================== SEE MEDIA DETAILS ====================
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        List<Media> results = store.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("No media found.");
            return;
        }
        System.out.println("Found " + results.size() + " media(s):");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ". " + results.get(i));
        }
        System.out.print("Choose media to add to cart (0 to cancel): ");
        int idx = getChoice(0, results.size());
        if (idx > 0) {
            cart.addMedia(results.get(idx - 1));
        }
    }

    // ==================== ADD TO CART ====================
    public static void addToCart() {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();
        List<Media> results = store.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("No media found.");
        } else {
            cart.addMedia(results.get(0)); // thêm cái đầu tiên tìm được
        }
    }

    // ==================== PLAY MEDIA ====================
    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        List<Media> results = store.searchByTitle(title);
        if (results.isEmpty()) {
            System.out.println("No media found.");
            return;
        }
        Media media = results.get(0);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    // ==================== UPDATE STORE ====================
    public static void updateStore() {
        while (true) {
            System.out.println("\nUpdate store:");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            int choice = getChoice(0, 2);
            if (choice == 0) return;

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            List<Media> results = store.searchByTitle(title);

            if (choice == 1) {
                // Thêm media mới (giả lập)
                System.out.println("Add media feature not fully implemented in this demo.");
            } else if (choice == 2) {
                if (!results.isEmpty()) {
                    store.removeMedia(results.get(0));
                } else {
                    System.out.println("Media not found.");
                }
            }
        }
    }

    // ==================== SEE CURRENT CART ====================
    public static void seeCurrentCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = getChoice(0, 5);

            switch (choice) {
                case 1 -> filterMediaInCart();
                case 2 -> sortCartMenu();
                case 3 -> removeFromCart();
                case 4 -> playMediaInCart();
                case 5 -> placeOrder();
                case 0 -> { return; }
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // Các method phụ trợ (filter, sort, remove, play, place order) có thể thêm sau
    public static void filterMediaInCart() { System.out.println("Filter feature coming soon..."); }
    public static void sortCartMenu() {
        System.out.println("1. Sort by title-cost");
        System.out.println("2. Sort by cost-title");
        int c = getChoice(1, 2);
        if (c == 1) cart.sortByTitleCost();
        else cart.sortByCostTitle();
        cart.print();
    }
    public static void removeFromCart() { System.out.println("Remove feature coming soon..."); }
    public static void playMediaInCart() { System.out.println("Play feature coming soon..."); }
    public static void placeOrder() {
        System.out.println("Order placed! Total cost: " + cart.totalCost() + " $");
        cart = new Cart(); // xóa giỏ hàng
    }

    // Helper method để nhập số hợp lệ
    private static int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) return choice;
                System.out.print("Invalid choice. Please try again: ");
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}