package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costComp = Float.compare(m2.getCost(), m1.getCost());
        if (costComp != 0) return costComp;
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}