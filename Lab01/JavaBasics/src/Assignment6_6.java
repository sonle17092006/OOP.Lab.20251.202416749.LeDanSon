

import java.util.Scanner;

public class Assignment6_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Do you want to enter the matrices yourself? (yes/no): ");
        String choice = input.nextLine().trim().toLowerCase();

        int rows, cols;
        int[][] A, B, C;

        if (choice.equals("yes")) {
            System.out.print("Enter number of rows: ");
            rows = input.nextInt();
            System.out.print("Enter number of columns: ");
            cols = input.nextInt();

            A = new int[rows][cols];
            B = new int[rows][cols];
            C = new int[rows][cols];

            System.out.println("Enter elements of first matrix (A):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("A[" + i + "][" + j + "] = ");
                    A[i][j] = input.nextInt();
                }
            }

            System.out.println("Enter elements of second matrix (B):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("B[" + i + "][" + j + "] = ");
                    B[i][j] = input.nextInt();
                }
            }

        } else {
            // Using constant matrices
            A = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };

            B = new int[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
            };

            rows = A.length;
            cols = A[0].length;
            C = new int[rows][cols];
        }

        // Perform addition
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // Display results
        System.out.println("\nMatrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        System.out.println("\nSum of A and B (Matrix C):");
        printMatrix(C);

        input.close();
    }

    // Helper function to print a matrix neatly
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}

