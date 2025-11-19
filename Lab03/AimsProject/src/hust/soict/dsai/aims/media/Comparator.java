// File: src/hust/soict/dsai/aims/media/MediaComparator.java
package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparator implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        if (m1 == null && m2 == null) return 0;
        if (m1 == null) return -1;
        if (m2 == null) return 1;

        // First: compare by title (case-insensitive)
        String title1 = m1.getTitle() == null ? "" : m1.getTitle();
        String title2 = m2.getTitle() == null ? "" : m2.getTitle();
        int titleComp = title1.compareToIgnoreCase(title2);

        if (titleComp != 0) {
            return titleComp;
        }

        // If titles are equal → compare by cost descending
        return Float.compare(m2.getCost(), m1.getCost());
    }
}