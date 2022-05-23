package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex66 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows in the matrices: ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of columns in the matrices: ");
        int n = scanner.nextInt();

        int array1[][] = new int[m][n];
        int array2[][] = new int[m][n];
        int sumArray[][] = new int[m][n];

        System.out.println("Please enter the elements of the first matrix");
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the elements of the row number "+ (i+1) + ":");
            for (int j = 0; j < n; j++)
                array1[i][j] = scanner.nextInt();
        }

        System.out.println("Please enter the elements of the second matrix");
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the elements of the row number "+ (i+1) + ":");
            for (int j = 0; j < n; j++)
                array2[i][j] = scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                sumArray[i][j] = array1[i][j] + array2[i][j];
        }

        System.out.println("The first matrix: " + Arrays.deepToString(array1));
        System.out.println("The first matrix: " + Arrays.deepToString(array2));
        System.out.println("Sum of the two matrices: " + Arrays.deepToString(sumArray));


    }
}

