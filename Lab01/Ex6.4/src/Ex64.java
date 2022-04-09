import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex64 {

    public static void main (String[] args) {

        int yearType = 1;

        String[] numDay31 = {"January", "Jan", "Jan.", "1",
                            "March", "Mar", "Mar.", "2",
                            "May","3",
                            "July", "Jul", "7",
                            "August", "Aug", "Aug.", "8",
                            "October", "Oct", "Oct.", "10",
                            "December", "Dec", "Dec.", "12"};

        String [] numDay30 = {"April", "Apr", "Apr.", "4",
                            "June", "Jun", "6",
                            "September", "Sep", "Sept.","9",
                            "November", "Nov", "Nov.", "11"};

        String [] february = {"February", "Feb", "Feb.", "2"};

        while (true) {

            System.out.print("Please enter the month: ");

            Scanner scanner = new Scanner(System.in);
            String month = scanner.next();
            
            try {
            
                System.out.print("Please enter the year: ");
                int year = scanner.nextInt();

                // yearType = 1 if it's a normal year, yearType = 2 if it's a leap year
                if (((year % 4 == 0) && (year%100 != 0)) || (year % 400 == 0))
                            yearType = 2;
                    else
                        yearType = 2;


                if (Arrays.asList(numDay31).contains(month)) {
                    System.out.println("This month has 31 days");
                    break;
                }
                    
                else if (Arrays.asList(numDay30).contains(month)) {
                    System.out.println("This month has 30 days");
                    break;
                }

                else if (Arrays.asList(february).contains(month)) {
                    if (yearType == 1)
                        System.out.println("This month has 28 days");
                    else 
                        System.out.println("This month has 29 days");
                    break;
                }

                else 
                    System.out.println("You've entered an invalid month. Please enter again");
            }
            catch (InputMismatchException e) {
                System.out.println("You've entered an invalid year. Please enter again");
            }  
        }
        
                           
    }
    
}

