package interviewQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the string 1 :: ");
        String str1 = scanner.next();
        System.out.println("Give the string 2 :: ");
        String str2 = scanner.next();
        if(str1.length()!=str2.length()) {
            System.out.println("Given string is not a anagram");
        }
        char[] carr = str1.toCharArray();
        char[] carr2 = str2.toCharArray();
        Arrays.sort(carr);
        Arrays.sort(carr2);
        boolean isAnagram=true;
        for(int i=0;i<carr.length;i++) {
            if(carr[i]!=carr2[i]) {
                isAnagram=false;
                break;
            }
        }
        if(isAnagram) {
            System.out.println("Given both strings are anagram");
        } else {
            System.out.println("Given both strings are not anagram");
        }
    }

}
