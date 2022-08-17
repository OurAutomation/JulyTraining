package newYork;

public class AirthmeticOperations {
    //Class variables
    int addTwo = 0;
    static int staticVariable = 12345;
    static long variable = 0;

    public int add(int a, int b) {
        /*staticVariable = 123;
        addTwo = 12345;
        int c = a + b;*/
        int c = addTwoNumbers(a, b);
        return c;
    }

    //public -- Public can be accessed anywhere in the project
//default -- It can be accessed only in the classes present in the same package
//private -- The methods declared as private cannot be accessed outside the class
//protected -- The protected keyword methods can be used in all the classes of the package and the child class extending that class
    static int addThreeNumbers(int a, int b, int c) {
        AirthmeticOperations airthmeticOperations = new AirthmeticOperations();
        airthmeticOperations.add(1, 2);
//        staticVariable=123;
        int j = addTwoNumbers(a, b);
        j = addTwoNumbers(j, c);
        return j;
    }

    public static int addTwoNumbers(int a, int b) {
        staticVariable = 123;
        int d = a + b;
        return d;
    }

    private static long addingTwoLongNumbers(long a, long b) {
        variable = a + b;
        return variable;
    }

    public static void main(String[] args) {
        addingTwoLongNumbers(123, 456);
    }

    static protected int subtractTwoNumbers(int h, int j) {
        return h - j;
    }

    static protected float divideTwoNumbers(int h, int j) {
        float f = h / j;
        return f;
    }
}
