// src/hust/soict/dsai/aims/media/Media.java
package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media implements Comparable<Media> {

    private static int nextId = 1;

    protected final int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
        this.id = nextId++;
    }

    public Media(String title) {
        this();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        return id == ((Media) o).id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f $",
                this.getClass().getSimpleName(),
                title != null ? title : "Untitled",
                category != null ? category : "No category",
                cost);
    }

    @Override
    public int compareTo(Media o) {
        if (o == null) return 1;
        if (title == null && o.title == null) return Float.compare(o.cost, cost);
        if (title == null) return -1;
        if (o.title == null) return 1;

        int titleComp = title.compareToIgnoreCase(o.title);
        if (titleComp != 0) return titleComp;
        return Float.compare(o.cost, cost); // descending cost
    }

    // COMPARATOR 1: Sort by Title (A→Z), then by Cost descending
    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            Comparator.comparing(
                    m -> m.getTitle() == null ? "" : m.getTitle().toLowerCase()
            ).thenComparing(Comparator.comparing(Media::getCost).reversed());

    // COMPARATOR 2: Sort by Cost descending, then by Title (A→Z)
    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            Comparator.comparingDouble(Media::getCost).reversed()
                    .thenComparing(m -> m.getTitle() == null ? "" : m.getTitle().toLowerCase());
}