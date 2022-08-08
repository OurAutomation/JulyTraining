package abstraction;

public interface ICar {
    public abstract void steer();
    public void tyre();
    public void body();
    public void lights();
    void doors();
    public default void glass() {
        System.out.println("glasses");
    }
}
