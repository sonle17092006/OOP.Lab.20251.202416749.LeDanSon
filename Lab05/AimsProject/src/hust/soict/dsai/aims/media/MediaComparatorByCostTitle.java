package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {
        // 1. So sánh cost giảm dần trước
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // 2. Nếu cost giống nhau → so sánh title alphabet
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}