package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    // Static counter – OK
    private static int nbDigitalVideoDiscs = 0;


    // ==================== Constructors ====================
    public DigitalVideoDisc(String title) {
        super(title);                    // ← thêm dấu ;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);    // ← thêm dấu ;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);   
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost); 
    }



    // getId() không cần viết lại vì đã có trong Media (protected)
    // getTitle(), getCategory(), getCost() cũng vậy

    // ==================== Search ====================
    public boolean isMatch(String title) {
        if (title == null || this.getTitle() == null) return false;
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    @Override
    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength() + " minutes");
    }

}