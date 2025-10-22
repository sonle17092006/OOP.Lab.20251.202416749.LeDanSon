package hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc() {
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this();
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this(category, title, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(director, category, title, cost);
        this.length = length;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }

    public boolean isPlayable() { return length > 0; }

    public boolean isMatch(String searchTitle) {
        if (searchTitle == null || title == null) return false;
        return title.toLowerCase().contains(searchTitle.toLowerCase());
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + (director != null ? director : "N/A") + 
               " - Length: " + length + ": " + cost + " $";
    }
}