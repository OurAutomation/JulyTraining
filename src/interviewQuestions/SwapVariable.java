package interviewQuestions;

public class SwapVariable {
    static int a = 10;
    static int b = 15;//a=15, b=10

    public static void main(String[] args) {
        //Swapping two variables by using third variable
        /*int c;
        c=a;
        a=b;
        b=c;
        */

        //Swapping without using third variable;
        /*a = a + b;
        b = a - b;
        a = a - b;*/

        a = a * b;
        b = a / b;
        a = a / b;
        System.out.println("Value of a is :: " + a);
        System.out.println("Value of b is :: " + b);

    }
}
