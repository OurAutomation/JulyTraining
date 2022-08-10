package exceptionHandling;

import java.io.File;
import java.io.IOException;

public class UnCheckedException {
    static ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    public static void main(String[] args) throws IOException {
        /*System.out.println(arithmeticOperations.divide(2, 1));
        System.out.println(arithmeticOperations.divide(4, 2));

        System.out.println(arithmeticOperations.divide(2, 0));

        System.out.println(arithmeticOperations.divide(6, 2));*/

        arithmeticOperations.readFromAFile(new File("ABC.txt"));

    }
}
