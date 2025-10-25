package hust.soict.dsai.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        super();
    }

    // Getters and Setters (as before)

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return title != null && title.equals(media.title);
    }
    @Override
    public String toString() {
        return "Media - ID: " + getId() + ", Title: " + getTitle() + ", Category: " + getCategory() + ", Cost: " + getCost() + " $";
    }
}