package org.training.java.abstraction;

public class CarVersion2 implements ICar {

    @Override
    public void steer() {
        System.out.println("Use power steering");
    }

    @Override
    public void tyre() {
        System.out.println("use CEAT tyres");
    }

    @Override
    public void body() {
        System.out.println("use fibre body");
    }

    @Override
    public void lights() {
        System.out.println("add fog lights also");
    }

    @Override
    public void doors() {

    }
}
