package org.training.java.loops;

import java.util.Scanner;

public class SwitchLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the state name :: ");
        String state = sc.next();
        switch(state) {
            case "maharastra":
                System.out.println("The capital is :: mumbai");
                break;
            case "karnataka":
                System.out.println("The capital is :: bangalore");
                break;
            case "telangana":
                System.out.println("The capital is :: hyderabad");
                break;
        }
        if(state.equals("maharastra") || state.equals("MAHARASTRA")){
            System.out.println("The capital is :: mumbai");
        } else if(state.equals("karnataka")) {
            System.out.println("The capital is :: bangalore");
        } else if(state.equals("telangana")) {
            System.out.println("The capital is :: hyderabad");
        }
    }
}
