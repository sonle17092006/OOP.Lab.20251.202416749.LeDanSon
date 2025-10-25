package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title) {
        super();
        setTitle(title);
    }

    public CompactDisc(String category, String title, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
    }

    public CompactDisc(String artist, String director, String category, String title, float cost) {
        this(category, title, cost);
        this.artist = artist;
        setDirector(director);
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (track != null && !tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added to CD.");
        } else {
            System.out.println("Track " + track.getTitle() + " is already in the CD or is null.");
        }
    }

    public void removeTrack(Track track) {
        if (track != null && tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed from CD.");
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the CD or is null.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle() + " - Length: " + getLength() + " seconds");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - Artist: " + (getArtist() != null ? getArtist() : "N/A") +
               " - Director: " + (getDirector() != null ? getDirector() : "N/A") + " - Length: " + getLength() +
               " - Cost: " + getCost() + " $";
    }
}