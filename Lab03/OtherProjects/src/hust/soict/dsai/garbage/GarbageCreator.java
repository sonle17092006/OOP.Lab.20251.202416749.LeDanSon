package hust.soict.dsai.garbage;

public class GarbageCreator {
    public static void main(String[] args) {
        String s = "";
        try {
            while (true) {
                s += "GarbageGarbageGarbageGarbage";  // tạo hàng triệu object String
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError occurred!");
            e.printStackTrace();
        }
    }
}