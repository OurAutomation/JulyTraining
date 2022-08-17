package encapsulation;

public class EngineImplementation {
    private int speed;
    private int rpm;
    private int brake;


    public int getSpeed() {
       if(rpm <=10) {
           return 20;
       }else if(rpm<=20) {
          return 30;
       } else {
           return 50;
       }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public int getBrake() {
        return brake;
    }

    public void setBrake(int brake) {
        this.brake = brake;
    }
}
