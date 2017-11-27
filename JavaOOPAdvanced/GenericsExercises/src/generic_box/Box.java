package generic_box;

public class Box<T> implements IBox {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n", this.value.getClass().getName(), this.value);
    }
}
