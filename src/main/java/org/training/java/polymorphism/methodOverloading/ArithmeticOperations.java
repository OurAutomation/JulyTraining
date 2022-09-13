package org.training.java.polymorphism.methodOverloading;

public class ArithmeticOperations {
    //this is a compiled time polymorphism
    //MethodSignature name+NumberOFParameters+TypeOfParameters

    //In method overloading the method signature should be different
    public double addition(double a, double b) {//add2doubledouble
        return a + b;
    }

    public double addition(double a, double b, double c) {//add3doubledoubledouble
        return a + b + c;
    }

    public int addition(int i, int j) {//add2intint
        return i + j;
    }
}
