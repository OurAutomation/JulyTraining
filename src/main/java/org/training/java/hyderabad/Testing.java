package org.training.java.hyderabad;

import org.training.java.newYork.AirthmeticOperations;

public class Testing extends AirthmeticOperations {
    public static void main(String[] args) {
//       AirthmeticOperations airthmeticOperations = new AirthmeticOperations();
        AirthmeticOperationsForHyderabad airthmeticOperationsForHyderabad = new AirthmeticOperationsForHyderabad();
        airthmeticOperationsForHyderabad.add(1, 2);
        airthmeticOperationsForHyderabad.addTwoDoubleNumbers(2, 3);
        subtractTwoNumbers(5,6);
    }
}
