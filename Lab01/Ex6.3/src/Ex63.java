
import java.util.Scanner;

public class Ex63 {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n = ");
        int n = scanner.nextInt();

        String emptySpace = " ";

        for (int i = n; i >= 1; i--)
            System.out.println(emptySpace.repeat(i-1)+ "*".repeat(2*(n-i)+1) + emptySpace.repeat(i-1));

        scanner.close();
    }
    
}

