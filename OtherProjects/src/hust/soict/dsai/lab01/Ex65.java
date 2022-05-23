package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex65 {
    public static void main (String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        int sum = 0, average;

        System.out.print("Enter the number of elements: ");;
        int n = scanner.nextInt();

        int[] array = new int[n];
        
        System.out.print("Enter the elements of the array: ");

        for (int i = 0; i<n; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        System.out.println("Your array is: " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("The sorted array is: " + Arrays.toString(array));
        
        average = sum/n;
        System.out.println("The sum of the array is: " + sum);
        System.out.println("The average of the array is: " + average);
    }
}

