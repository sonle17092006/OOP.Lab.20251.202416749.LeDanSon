package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        String s = "";
        long start = System.currentTimeMillis();

        for (int i = 0; i < 65536; i++) {        // 2^16 lần lặp
            s += "a";                            // DÙNG + → TẠO HÀNG NGHÌN OBJECT MỚI!
        }

        long end = System.currentTimeMillis();
        System.out.println("Using + operator: " + (end - start) + " ms");
        // Trên máy mình: ~4500–8000 ms → cực chậm!
    }
}