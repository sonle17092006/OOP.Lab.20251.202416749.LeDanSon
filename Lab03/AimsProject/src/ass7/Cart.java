package ass7;

//Cart.java
public class Cart {
 public static final int MAX_NUMBERS_ORDERED = 20;
 private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
 private int qtyOrdered = 0;

 public void addDigitalVideoDisc(DigitalVideoDisc disc) {
     if (qtyOrdered == MAX_NUMBERS_ORDERED) {
         System.out.println("The cart is almost full");
         return;
     }
     itemsOrdered[qtyOrdered] = disc;
     qtyOrdered++;
     System.out.println("The disc has been added");
 }

 // Overloaded: add list
 public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
     for (DigitalVideoDisc disc : dvdList) {
         addDigitalVideoDisc(disc);
     }
 }

 // Overloaded: add two DVDs
 public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
     addDigitalVideoDisc(dvd1);
     addDigitalVideoDisc(dvd2);
 }

 // Varargs version (arbitrary number)
 public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
     for (DigitalVideoDisc disc : dvds) {
         addDigitalVideoDisc(disc);
     }
 }

 public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
     for (int i = 0; i < qtyOrdered; i++) {
         if (itemsOrdered[i] == disc) {
             // Shift array
             for (int j = i; j < qtyOrdered - 1; j++) {
                 itemsOrdered[j] = itemsOrdered[j + 1];
             }
             itemsOrdered[qtyOrdered - 1] = null;
             qtyOrdered--;
             System.out.println("The disc has been removed");
             return;
         }
     }
     System.out.println("The disc not found");
 }

 public float totalCost() {
     float total = 0;
     for (int i = 0; i < qtyOrdered; i++) {
         total += itemsOrdered[i].getCost();
     }
     return total;
 }

 // Method to print the cart
 public void print() {
     for (int i = 0; i < qtyOrdered; i++) {
         DigitalVideoDisc dvd = itemsOrdered[i];
         System.out.println((i + 1) + " " + dvd.getTitle() + " " + dvd.getCost());
     }
     System.out.println("Total Cost " + totalCost());
 }
}
