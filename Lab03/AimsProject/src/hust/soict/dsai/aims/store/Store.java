package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import java.util.ArrayList;

public class Store {
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

    public void displayMediaDetails(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No media found with ID: " + id);
    }

    public void playMedia(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id && media instanceof Playable) {
                ((Playable) media).play();
                return;
            }
        }
        System.out.println("No playable media found with ID: " + id);
    }
}