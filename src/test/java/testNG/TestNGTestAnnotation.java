package testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGTestAnnotation {
    /*public static void main(String[] args) {
        System.out.println(1+2);
    }*/
@BeforeSuite
public void beforeSuite() {
    System.out.println("Before Suite");
}
    @Test
    public void addTwoNumbers_0() {
        System.out.println(1+2);
    }
    @Test
    public void addThreeNumbers_1() {
        System.out.println(1+2+3);
    }
    @Test
    public void addFourNumbers_2() {
        System.out.println(1+2+3+4);
    }
}
