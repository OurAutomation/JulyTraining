package org.training.java.loops;

public class ForLoopWithBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5)
                break;
        }

        for (int i = 1; ; i++) {
            System.out.println("test");
            if (i == 20)
                break;
        }
    }
}
