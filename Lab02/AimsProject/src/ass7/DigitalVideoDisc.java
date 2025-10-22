package ass7;

//DigitalVideoDisc.java
public class DigitalVideoDisc {
 private String title;
 private String category;
 private String director;
 private int length;
 private float cost;
 private int id;
 private static int nbDigitalVideoDiscs = 0;

 // Constructor by title
 public DigitalVideoDisc(String title) {
     this.title = title;
     nbDigitalVideoDiscs++;
     this.id = nbDigitalVideoDiscs;
 }

 // Constructor by category, title, cost
 public DigitalVideoDisc(String category, String title, float cost) {
     this.category = category;
     this.title = title;
     this.cost = cost;
     nbDigitalVideoDiscs++;
     this.id = nbDigitalVideoDiscs;
 }

 // Constructor by director, category, title, cost
 public DigitalVideoDisc(String director, String category, String title, float cost) {
     this.director = director;
     this.category = category;
     this.title = title;
     this.cost = cost;
     nbDigitalVideoDiscs++;
     this.id = nbDigitalVideoDiscs;
 }

 // Constructor by all attributes
 public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
     this.title = title;
     this.category = category;
     this.director = director;
     this.length = length;
     this.cost = cost;
     nbDigitalVideoDiscs++;
     this.id = nbDigitalVideoDiscs;
 }

 public String getTitle() {
     return title;
 }

 public String getCategory() {
     return category;
 }

 public String getDirector() {
     return director;
 }

 public int getLength() {
     return length;
 }

 public float getCost() {
     return cost;
 }

 public int getId() {
     return id;
 }

 // Temporary setter for title (for section 15)
 public void setTitle(String title) {
     this.title = title;
 }
}
