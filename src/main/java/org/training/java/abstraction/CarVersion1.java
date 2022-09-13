package org.training.java.abstraction;

public class CarVersion1 extends AbstractClass implements ICar,IBody  {
    @Override
    public void steer() {
        System.out.println("use manual");
    }

    @Override
    public void tyre() {
        System.out.println("use MRF");
    }

    @Override
    public void body() {
        System.out.println("use plastic body");
    }

    @Override
    public void lights() {
        System.out.println("Use only head lights");
    }

    @Override
    public void method() {

    }

    @Override
    public void windShield() {

    }

    @Override
    public void sunRoof() {

    }

    @Override
    public void doors() {

    }

    @Override
    public void glass() {
        IBody.super.glass();
    }
}
