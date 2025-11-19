package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media != null && !itemsInStore.contains(media)) {
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public void displayStore() {
        System.out.println("*********************** STORE ***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("***************************************************");
    }

    public Media searchByTitle(String title) {
        return itemsInStore.stream()
                .filter(m -> m.getTitle().toLowerCase().contains(title.toLowerCase()))
                .findFirst().orElse(null);
    }
}