package hust.soict.dsai.aims.disc;


public class DigitalVideoDisc {
	private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;

    // Class variable (static) - shared among all DVD instances
    private static int nbDigitalVideoDiscs = 0;

    // Constructor 1: title only
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;        // increase total count
        this.id = nbDigitalVideoDiscs; // assign current count as ID
    }

    // Constructor 2: title + category
    public DigitalVideoDisc(String title, String category) {
        this(title);
        this.category = category;
    }

    // Constructor 3: title + category + director
    public DigitalVideoDisc(String title, String category, String director) {
        this(title, category);
        this.director = director;
    }

    // Constructor 4: title + category + director + length
    public DigitalVideoDisc(String title, String category, String director, int length) {
        this(title, category, director);
        this.length = length;
    }

    // Constructor 5: all fields
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, length);
        this.cost = cost;
    }
    // ============ ONLY GETTERS (NO SETTERS) ============
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }
    public int getId() {
        return id;
    }

    // toString() - exactly as expected in Lab 2
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " min - " + cost + " $";
    }

	public void setTitle(String title2) {
		// TODO Auto-generated method stub
		this.title = title2;
	}
}