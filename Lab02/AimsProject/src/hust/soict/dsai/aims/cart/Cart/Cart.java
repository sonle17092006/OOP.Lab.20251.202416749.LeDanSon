package hust.soict.dsai.aims.cart.Cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;


public class Cart {
    private DigitalVideoDisc[] items = new DigitalVideoDisc[20];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= 20) {
            System.out.println("The cart is almost full");
            return;
        }
        items[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                return;
            }
        }
        System.out.println("The disc is not in the cart");
    }

    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += items[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + items[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i].getId() == id) {
                System.out.println("Found: " + items[i].toString());
                return;
            }
        }
        System.out.println("No match found for ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (items[i].isMatch(title)) {
                System.out.println("Found: " + items[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
    }
}