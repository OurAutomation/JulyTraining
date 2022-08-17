package polymorphism.methodOverriding;

public class ChildClass extends ParentClass {
    //Runtime polymorphism
    //Method signature should be same
    @Override
    public void methodB() {
        System.out.println("child class method B");
    }
}
