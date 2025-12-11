package hust.soict.dsai.aims.media;
import java.util.Comparator;
public abstract class Media{   // ← XÓA implements Comparable<Media>

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
    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra null
        if (obj == null) {
            return false;
        }

        // 2. Kiểm tra cùng instance hoặc cùng class
        if (!(obj instanceof Media)) {
            return false;
        }

        // 3. Ép kiểu và so sánh title
        Media other = (Media) obj;

        // 4. Kiểm tra NullPointerException cho title
        if (this.getTitle() == null) {
            return other.getTitle() == null;
        }

        // 5. So sánh title (không phân biệt hoa thường như yêu cầu phổ biến)
        return this.getTitle().equals(other.getTitle());
    }

}