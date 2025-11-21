package temp;

public class DigitalVideoDisc {

    // Thuộc tính class (static) – đếm tổng số DVD đã tạo
    private static int nbDigitalVideoDiscs = 0;

    // Thuộc tính instance – mỗi DVD có 1 ID duy nhất
    private int id;

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor 1: chỉ title
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;        // tăng trước → ID bắt đầu từ 1
    }

    // Constructor 2: title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 3: title, category, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Constructor 4: đầy đủ tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getter cho ID (rất hay cần dùng)
    public int getId() {
        return id;
    }

    // Getter cho static counter (để kiểm tra nếu cần)
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // Các getter còn lại
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }

    // toString để in đẹp hơn khi test
    @Override
    public String toString() {
        return "DVD [ID=" + id + "] - " + title +
               (category != null ? " - " + category : "") +
               (director != null ? " - " + director : "") +
               (length > 0 ? " - " + length + "min" : "") +
               " - " + cost + " $";
    }
}