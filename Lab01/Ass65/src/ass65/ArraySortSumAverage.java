package ass65;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Let user choose to enter numbers or use constant array
        System.out.print("Do you want to enter numbers yourself? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        int[] my_array1;

        if (choice.equals("yes")) {
            System.out.print("Enter number of elements: ");
            int n = input.nextInt();
            my_array1 = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                my_array1[i] = input.nextInt();
            }
        } else {
            // constant array (like in the image)
            my_array1 = new int[] {1789, 2035, 1899, 1456, 2013};
        }

        // Display the original array
        System.out.println("Original array: " + Arrays.toString(my_array1));

        // Sort the array
        Arrays.sort(my_array1);
        System.out.println("Sorted array: " + Arrays.toString(my_array1));

        // Calculate sum and average
        int sum = 0;
        for (int num : my_array1) {
            sum += num;
        }
        double average = (double) sum / my_array1.length;

        // Display results
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);

        input.close();
    }
}
