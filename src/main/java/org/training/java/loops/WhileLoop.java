package org.training.java.loops;

public class WhileLoop {
    public static void main(String[] args) {
       /* boolean variable = true;
        int i = 0;
        while (variable) {
            i++;
            System.out.println("print");
            if (i == 10)
                variable=false;
        }
        i=11;
        do {
            i++;
            System.out.println("Test");
        }while (i<10);
        i=11;
        while (i<10) {
            i++;
            System.out.println("print");
        }*/

        //continue will execute the loop again
        //break will stop executing the loop
        int i=0;
        while(true) {
            ++i;
            if(i==10)
                continue;
            System.out.println(i);

            if(i==50)
                break;
        }
    }
}
