package abstraction;

public interface IBody {
    void windShield();
    void sunRoof();
    void doors();
    public default void glass() {
        System.out.println("glasses");
    }
}
