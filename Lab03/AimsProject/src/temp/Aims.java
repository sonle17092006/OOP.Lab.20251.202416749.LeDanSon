package temp;


public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart anOrder = new Cart();

        // Tạo một vài DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Thêm DVD vào giỏ
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // In giỏ hàng trước khi xóa
        System.out.println("=== Giỏ hàng trước khi xóa ===");
        System.out.println("Số lượng DVD: " + anOrder.getQtyOrdered());
        System.out.println("Tổng tiền: " + anOrder.totalCost() + " $");

        // XÓA DVD "Star Wars" khỏi giỏ
        System.out.println("\nĐang xóa DVD \"Star Wars\" khỏi giỏ hàng...");
        anOrder.removeDigitalVideoDisc(dvd2);

        // In lại giỏ hàng sau khi xóa để kiểm tra
        System.out.println("\n=== Giỏ hàng sau khi xóa ===");
        System.out.println("Số lượng DVD: " + anOrder.getQtyOrdered());
        System.out.println("Tổng tiền: " + anOrder.totalCost() + " $");
    }
}