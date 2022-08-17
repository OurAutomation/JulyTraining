package inheritance;

public class CarVersion2 extends CarVersion1 {
    int steering = 10;

    public void sunRoof() {
        System.out.println(this.steering);
    }
}
