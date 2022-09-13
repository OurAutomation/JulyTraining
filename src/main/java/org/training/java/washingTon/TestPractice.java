package org.training.java.washingTon;

public class TestPractice {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.drive();
        car.steer();

        car = new Car("ferrari");
        car.drive();
        car.steer();
    }
}
