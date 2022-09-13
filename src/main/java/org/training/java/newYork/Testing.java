package org.training.java.newYork;

import org.training.java.hyderabad.AirthmeticOperationsForHyderabad;

public class Testing {
    //f7 :- go inside the method
    //f8 :- go to next line
    //f9 :- goto next debug point
    public static void main(String[] args) {
        AirthmeticOperationsForHyderabad airthmeticOperationsForHyderabad = new AirthmeticOperationsForHyderabad();
        airthmeticOperationsForHyderabad.add(1, 2);
        airthmeticOperationsForHyderabad.addTwoDoubleNumbers(2, 3);
        airthmeticOperationsForHyderabad.addTwoDoubleNumbers(2, 3);
        System.out.println(AirthmeticOperationsForHyderabad.divideTwoNumbers(5, 6));
        System.out.println(AirthmeticOperationsForHyderabad.divideTwoNumbers(6, 2));
        System.out.println(AirthmeticOperationsForHyderabad.divideTwoNumbers(9, 0));
        System.out.println(AirthmeticOperationsForHyderabad.divideTwoNumbers(7, 3));
    }
}
