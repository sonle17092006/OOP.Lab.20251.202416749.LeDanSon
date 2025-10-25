package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Media - ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + " $";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title != null && title.equals(media.title);
    }

    // Comparator for sorting by title, then cost (descending)
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(m2.getCost(), m1.getCost()); // Higher cost first
        }
    };

    // Comparator for sorting by cost, then title
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        @Override
        public int compare(Media m1, Media m2) {
            int costComparison = Float.compare(m2.getCost(), m1.getCost()); // Decreasing cost order
            if (costComparison != 0) {
                return costComparison;
            }
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        }
    };
}