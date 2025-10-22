package ass7;

//Aims.java
public class Aims {
 public static void main(String[] args) {
     // Create a new cart
     Cart anOrder = new Cart();

     // Create new dvd objects and add them to the cart
     DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
     anOrder.addDigitalVideoDisc(dvd1);

     DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
     anOrder.addDigitalVideoDisc(dvd2);

     DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
     anOrder.addDigitalVideoDisc(dvd3);

     // Print total cost of the items in the cart
     System.out.println("Total Cost is: ");
     System.out.println(anOrder.totalCost());

     // Display cart items
     anOrder.print();

     // Test remove
     anOrder.removeDigitalVideoDisc(dvd3);

     // Display again
     anOrder.print();

     // Test overloading
     DigitalVideoDisc dvd4 = new DigitalVideoDisc("Another DVD", "Category", 10.0f);
     DigitalVideoDisc dvd5 = new DigitalVideoDisc("Yet Another", "Category", 15.0f);
     anOrder.addDigitalVideoDisc(dvd4, dvd5);

     anOrder.print();

     // Varargs test
     DigitalVideoDisc dvd6 = new DigitalVideoDisc("Varargs1", 5.0f);
     DigitalVideoDisc dvd7 = new DigitalVideoDisc("Varargs2", 6.0f);
     anOrder.addDigitalVideoDisc(dvd6, dvd7);

     anOrder.print();
 }
}
