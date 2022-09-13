package org.training.java.interviewQuestions;

public class RemoveAllDigitsInTheString {
    static String s = "my 12 #trrbn RT 5656 $%1243";

    public static void main(String[] args) {
        //remove all digits
        System.out.println(s.replaceAll("[0-9]",""));
        //remove all alphabets
        System.out.println(s.replaceAll("[A-Za-z]",""));
        //remove all except symbols
        System.out.println(s.replaceAll("[A-Za-z0-9]",""));
        //remove all the symbols
        System.out.println(s.replaceAll("[^A-Za-z0-9]",""));
    }
}
