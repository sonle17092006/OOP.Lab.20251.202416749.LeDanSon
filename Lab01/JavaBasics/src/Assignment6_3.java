

import java.util.Scanner;

public class Assignment6_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the height of the triangle (n): ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            // In khoảng trắng trước
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            // In dấu *
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println(); // Xuống dòng
        }

        input.close();
    }
}


