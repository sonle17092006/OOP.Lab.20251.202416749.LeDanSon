// src/hust/soict/dsai/aims/cart/Cart.java
package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (media != null && !itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (media != null && itemsOrdered.remove(media)) {
            System.out.println("Removed: " + media.getTitle());
        }
    }

    public float totalCost() {
        return (float) itemsOrdered.stream().mapToDouble(Media::getCost).sum();
    }

    public void print() {
        System.out.println("*********************** CART ***********************");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    public void sortByTitleCost() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void searchById(int id) {
        itemsOrdered.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                    m -> System.out.println("Found: " + m),
                    () -> System.out.println("No media found with ID: " + id)
                );
    }

    public void searchByTitle(String keyword) {
        boolean found = itemsOrdered.stream()
                .anyMatch(m -> m.getTitle() != null &&
                        m.getTitle().toLowerCase().contains(keyword.toLowerCase()));

        if (found) {
            itemsOrdered.stream()
                    .filter(m -> m.getTitle() != null &&
                            m.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .forEach(m -> System.out.println("Found: " + m));
        } else {
            System.out.println("No match found for title: " + keyword);
        }
    }
}