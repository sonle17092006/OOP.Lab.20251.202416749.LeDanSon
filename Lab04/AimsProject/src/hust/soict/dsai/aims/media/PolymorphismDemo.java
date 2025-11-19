package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        // Tạo các đối tượng đúng cách (Lab 04)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 120, 24.95f);

        Book book = new Book("Java Programming");  // BẮT BUỘC có title
        book.addAuthor("James Gosling");
        book.setCost(49.99f);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", null, "Michael Jackson", 15.99f);
        cd.addTrack(new Track("Billie Jean", 294));
        cd.addTrack(new Track("Beat It", 258));

        // Thêm vào danh sách
        mediae.add(dvd1);
        mediae.add(dvd2);
        mediae.add(book);
        mediae.add(cd);

        // In ra → chứng minh tính đa hình (polymorphism)
        System.out.println("=== Polymorphism Demo ===");
        for (Media m : mediae) {
            System.out.println(m.toString());  // Gọi đúng toString() của từng class con

            // Nếu có thể play → play luôn
            if (m instanceof Playable) {
                ((Playable) m).play();
            }
            System.out.println("---");
        }
    }
}