package org.training.java.encapsulation;

public class Test {
    static EngineImplementation engineImplementation = new EngineImplementation();

    public static void main(String[] args) {
        engineImplementation.setRpm(20);
        System.out.println(engineImplementation.getSpeed());
    }
}
