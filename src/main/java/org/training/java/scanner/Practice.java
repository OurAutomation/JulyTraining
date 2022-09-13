package org.training.java.scanner;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age :: ");
        int age = scanner.nextInt();
        System.out.println("Enter the name :: ");
        String name = scanner.next();
        System.out.println("Hi, My name is :: " + name +" and my age is :: " + age);
    }
}
