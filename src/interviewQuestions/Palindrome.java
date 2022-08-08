package interviewQuestions;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the string :: ");
        String str = scanner.next();
        String reverseString = reverseTheGivenString(str);
        if(str.equals(reverseString)) {
            System.out.println("Given string is palindrome");
        } else {
            System.out.println("Given string is not a palindrome");
        }
    }

    public static String reverseTheGivenString(String str) {
        String reverseString = "";
        char[] carr = str.toCharArray();
        for(int i= carr.length-1;i>=0;i--) {
            reverseString +=carr[i];
        }
        return reverseString;
    }
}
