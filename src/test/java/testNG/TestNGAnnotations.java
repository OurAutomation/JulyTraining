package testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    /*public static void main(String[] args) {
        System.out.println(1+2);
    }*/
    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @Test
    public void addTwoNumbers() {
        System.out.println(1 + 2);
    }

    @Test
    public void addThreeNumbers() {
        System.out.println(1 + 2 + 3);
    }

    @Test
    public void addFourNumbers() {
        System.out.println(1 + 2 + 3 + 4);
    }
}
