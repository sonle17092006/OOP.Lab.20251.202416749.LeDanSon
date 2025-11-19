package hust.soict.dsai.aims.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", null, null, 0, 0);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", null, null, 0, 0);

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());   // Still "Jungle"
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle()); // Still "Cinderella"

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());   // Now "Cinderella"
    }

    public static void swap(Object o1, Object o2) {
        // Doesn't work — only swaps references inside method
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(title); // Doesn't affect outside
    }
}