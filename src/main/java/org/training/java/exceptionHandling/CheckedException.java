package org.training.java.exceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedException {
    public static void main(String[] args) throws FileNotFoundException {

        //checked exception --This exception occurs in compile time
        //unchecked exception -- This exception occurs in run time

        createAFile();


    }

    public static void createAFile() {
//        createAFile();
        System.out.println("before");
        File file = new File("");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            System.out.println("Inside the try block");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Inside the catch block");
        }
        System.out.println("after");
    }
}
