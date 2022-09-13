package org.training.java.loops;

public class IfElseLoop {
    public static void main(String[] args) {
        int i = 100;
        if (i < 10) {
            System.out.println("I is less than 10");
            i = i + 1;
        } else if (i == 10) {
            System.out.println("i is equal to 10");
            i++;
        } else {
            System.out.println("i is greater than 10");
        }
    }

    public static boolean checkIfThePersonIsValidToCreateAnEmail(int age) {
        if ((age >= 18) == true) {
            return true;
        } else {
            return false;
        }
    }
}
