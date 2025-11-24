package temp;

public class Cart {

    public static final int MAX_ORDERED_NUMBER = 20;

    // Sửa 2 lỗi lớn ở đây:
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_ORDERED_NUMBER];  // thêm ; và [] đúng vị trí
    private int qtyOrdered = 0;

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_ORDERED_NUMBER) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");  // thêm ;
        } else {
            System.out.println("The cart is almost full");   // thêm ;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                return;
            }
        }
        System.out.println("Disc not found in cart.");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (disc != null) {
                addDigitalVideoDisc(disc);  // tận dụng lại method cũ để kiểm tra giới hạn
            }
        }
        System.out.println("The list of DVDs has been added.");
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);   // tái sử dụng method cũ cho gọn
        addDigitalVideoDisc(dvd2);
    }

    public float totalCost() {
        float tc = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            tc += itemsOrdered[i].getCost();  // thêm ;
        }
        return tc;  // thêm ;
    }
}