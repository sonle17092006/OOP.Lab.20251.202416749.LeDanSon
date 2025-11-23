package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media implements Playable{   // ← XÓA implements Comparable<Media>

    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    // Constructors
    public Media() {
        // constructor mặc định
    }
    public Media(String title) { this.title = title; }
    public Media(String title, String category) { this(title); this.category = category; }
    public Media(String title, String category, float cost) { this(title, category); this.cost = cost; }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
            new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
            new MediaComparatorByCostTitle();

    // toString() – BẮT BUỘC CÓ
    @Override
    public String toString() {
        return String.format("%s - %s: %.2f $", 
            title != null ? title : "Unknown",
            category != null ? category : "Unknown",
            cost);
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // 1. Nếu 2 object là cùng 1 cái → bằng nhau
        if (obj == null || !(obj instanceof Track)) return false; // 2. Nếu obj là null hoặc không phải Track → không bằng
        Media other = (Media) obj;                       // 3. ← CHÍNH LÀ DÒNG NÀY!
        return title.equals(other.getTitle());
    }
    public void play() {
	}

}