import java.util.Scanner;

public class CalTwoNumbers {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("The first number is: ");
        double num1 = scanner.nextDouble();

        System.out.print("The second number is: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        double difference = Math.abs(num1 - num2);
        double product = num1*num2;
        double quotient = num1/num2;
        double divisor = num1%num2;

        System.out.println("The sum of two numbers is: " + sum);
        System.out.println("The difference of two numbers is: " + difference);
        System.out.println("The product of two numbers is: " + product);
        System.out.println("The quotient of two numbers is: " + quotient + " with divisor: " + divisor);

        scanner.close();
    }
    
}
