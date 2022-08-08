package washingTon;

public class Car {
    final String car;

    public Car(String car) {
        this.car = car;
    }

    //Blank final concept

    public void drive() {
        System.out.println("I am driving a car :: " + car);
    }

    public void steer() {
        System.out.println("I am handling the steering of a car :: " + car);
    }
}
