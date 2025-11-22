package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{

    // ==================== 2 fields mới theo yêu cầu ====================
    private String artist;                          // private
    private List<Track> tracks = new ArrayList<>(); // private

    // ==================== Constructors ====================
    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, 
                       float cost, String artist) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, 
                       int length, float cost, String artist) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    // ==================== Chỉ có getter cho artist (không có setter) ====================
    public String getArtist() {
        return artist;
    }

    // ==================== addTrack + removeTrack (có kiểm tra) ====================
    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add null track.");
            return;
        }
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" is already in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added to the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot remove null track.");
            return;
        }
        if (tracks.remove(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" is not in the CD.");
        }
    }

    // ==================== getLength() = tổng length của tất cả track ====================

    // ==================== toString() đẹp ====================
    @Override
    public String toString() {
        return "CD - " + getTitle() + 
               " - " + (getCategory() != null ? getCategory() : "") +
               " - " + (getDirector() != null ? getDirector() : "") +
               " - " + artist +
               " - " + getLength() + " min: " + getCost() + " $";
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("CD total length: " + getLength() + " minutes");
        System.out.println("=== Track List ===");
        
        if (tracks.isEmpty()) {
            System.out.println("No tracks in this CD.");
        } else {
            for (int i = 0; i < tracks.size(); i++) {
                System.out.println((i + 1) + ". " + tracks.get(i).getTitle() 
                                 + " (" + tracks.get(i).getLength() + " min)");
            }
        }
        System.out.println("==================");

        // Gọi play() cho từng track
        for (Track track : tracks) {
            try {
                track.play();           // mỗi track sẽ tự in thông tin
            } catch (Exception e) {
                System.err.println("Cannot play track: " + track.getTitle());
            }
        }
    }

    // ==================== compareTo (bắt buộc vì Media implements Comparable) ====================

}