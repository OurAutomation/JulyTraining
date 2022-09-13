package org.training.java.operators;

public class Practice {
    /*
    = Single equal is used to assign, double w=equal is used to compare
    <
    >
    + -- Increment Operator
    - -- decrement Operator
     */
    public static void main(String[] args) {
        int a=10;
        int b=10;
        System.out.println(checkIfGivenNumbersAreSame(1,10));
        System.out.println(checkIfGivenNumbersAreSame(10,10));
        System.out.println(checkIfGivenBooleanValuesAreSame(true,true));
        System.out.println(checkIfGivenBooleanValuesAreSame(true,false));
        System.out.println(checkIfGivenCharactersAreSame('c','d'));
        System.out.println(checkIfGivenCharactersAreSame('b','b'));

        int age = 10;
        a = a + 1;
        a = a - 1;
        a = a * 2;
        a = a / 2;
        ++a;
        a++;
        a++;
        int ageAfterOneYear=age++;
        System.out.println(++a);
        --a;
        a--;
        System.out.println(ageAfterOneYear);

    }

    public static boolean checkIfGivenNumbersAreSame(int i, int j) {
        boolean areTwoNumbersEqual = (i == j);
        return areTwoNumbersEqual;
    }

    public static boolean checkIfGivenBooleanValuesAreSame(boolean i, boolean j) {
        boolean areTwoNumbersEqual = (i == j);
        return areTwoNumbersEqual;
    }

    public static boolean checkIfGivenCharactersAreSame(char i, char j) {
        boolean areTwoNumbersEqual = (i == j);
        return areTwoNumbersEqual;
    }

    public static boolean isGivenNumberGreaterThan100(int i) {
        boolean isGreaterThan100 = i > 100;
        return isGreaterThan100;
    }

    public static boolean isGivenNumberLessThan100(int i) {
        boolean isLessThan100 = i < 100;
        return isLessThan100;
    }

    public static boolean isGivenNumberGreaterThanOrEqual100(int i) {
        boolean isGreaterThan100 = i >= 100;
        return isGreaterThan100;
    }

    public static boolean isGivenNumberLessThanOrEqual100(int i) {
        boolean isLessThan100 = i <= 100;
        return isLessThan100;
    }
}
