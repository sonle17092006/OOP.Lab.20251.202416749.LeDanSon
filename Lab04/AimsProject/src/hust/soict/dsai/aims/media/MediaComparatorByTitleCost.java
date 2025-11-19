package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComp = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComp != 0) return titleComp;
        return Float.compare(m2.getCost(), m1.getCost());
    }
}