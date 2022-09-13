package org.training.java.polymorphism;

import org.training.java.polymorphism.methodOverriding.ChildClass;
import org.training.java.polymorphism.methodOverriding.ParentClass;
import org.training.java.polymorphism.methodOverloading.ArithmeticOperations;

public class Test {
    public static void main(String[] args) {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        System.out.println(arithmeticOperations.addition(1,2));
        System.out.println(arithmeticOperations.addition(1.1,2.1));
        System.out.println(arithmeticOperations.addition(1.1,2.1,3));
        ChildClass childClass = new ChildClass();
        childClass.methodA();
        childClass.methodB();
        ParentClass classA = new ChildClass();
        classA.methodB();
        classA = new ParentClass();
        classA.methodB();
    }
}
