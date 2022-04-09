import java.util.Scanner;

public class EquationSolver {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the equation type: (Type 1 for linear equation, type 2 for linear system, type 3 for second-degree equation with one variable");
        int equationType = scanner.nextInt();

        if (equationType == 1) {
            System.out.println("Your equation would have the form: ax + b = 0\n Please enter the coefficients a and b");

            System.out.print("a = ");
            double a = scanner.nextDouble();

            System.out.print("b = ");
            double b = scanner.nextDouble();

            if (a == 0) {
                if (b != 0)
                    System.out.println("Your equation has 0 solutions");
                else
                    System.out.println("Your equation has infinitely many solutions x = t with t is any arbitrary real number ");
            }
            else {
                double result = -b/a;
                System.out.println("The solution for your equation is x = " + result);
        
            }

        }    

        else if (equationType == 2) {
            
            System.out.println("Your system would have the following form\na11 x1 + a12 x2 = b1\na21 x1 + a22 x2 = b2");
            
            System.out.print("a11 = ");
            double a11 = scanner.nextDouble();

            System.out.print("a12 = ");
            double a12 = scanner.nextDouble();

            System.out.print("a21 = ");
            double a21 = scanner.nextDouble();

            System.out.print("a22 = ");
            double a22 = scanner.nextDouble();

            System.out.print("b1 = ");
            double b1 = scanner.nextDouble();

            System.out.print("b2 = ");
            double b2 = scanner.nextDouble();

            double D = a11*a22 - a21*a12;
            double D1 = b1*a22 - b2*a12;
            double D2 = b2*a11 - b1*a21;

            if (D != 0) 
                System.out.println("The solution is x1 = " + D1/D + ", x2 = " + D2/D);
            else {
                if (D1 == 0)
                    System.out.println("This equation has infinity has solution x = a, y = b with a, b are any arbitrary numbers");
                else
                    System.out.println("This equation has no real solutions");

            } 
        }
                
        else if (equationType == 3) {
            System.out.println("Your system would have the following form ax2 + bx + c = 0");
            
            System.out.print("a = ");
            double a = scanner.nextDouble();

            System.out.print("b = ");
            double b = scanner.nextDouble();

            System.out.print("c = ");
            double c = scanner.nextDouble();

            if (a == 0) {
                System.out.println("This is a linear equation, please type one instead.");
            
            }
            else {
                double delta = b*b - 4*a*c;
                if (delta < 0)
                    System.out.println("This equation has no solutions");
                else if (delta ==0)
                    System.out.println("This equation has a double root x = " + -b/(2*a));
                else 
                    System.out.println("This equation has 2 solutions x = " + (-b-Math.sqrt(delta))/(2*a) + "and x = " +  (-b+Math.sqrt(delta))/(2*a));
                }    
        
        }

        scanner.close();
    }
    
}
