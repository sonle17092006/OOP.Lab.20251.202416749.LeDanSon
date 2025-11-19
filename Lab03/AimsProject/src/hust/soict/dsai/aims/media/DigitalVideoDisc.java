// src/hust/soict/dsai/aims/media/DigitalVideoDisc.java
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() { return director; }
    public int getLength() { return length; }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.title);
        System.out.println("DVD length: " + this.length + " minutes");
    }

    @Override
    public String toString() {
        return "DVD - " + title +
               (category != null ? " - " + category : "") +
               (director != null ? " - " + director : "") +
               " - " + length + " min: " + cost + " $";
    }
}