// src/hust/soict/dsai/aims/media/Track.java
package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() { return title; }
    public int getLength() { return length; }

    @Override
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length + " seconds");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track t = (Track) o;
        return length == t.length && title.equals(t.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode() * 31 + length;
    }
}