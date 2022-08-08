package interviewQuestions;

import java.util.Scanner;

public class PrintTheWordsOfAStringInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the string :: ");
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        String reverseWords = "";
        for(int i=s.length-1;i>=0;i--) {
            reverseWords +=s[i]+" ";
        }
        System.out.println(reverseWords);
    }
}
