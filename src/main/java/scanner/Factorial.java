package scanner;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for factorial :: ");
        double factorialNumber = sc.nextDouble();
        double factorialValue=1;
        for (double i=factorialNumber;i>=1;i--) {
            factorialValue = factorialValue*i;
        }
        System.out.println("The factorial value is :: " + factorialValue);
    }
}
