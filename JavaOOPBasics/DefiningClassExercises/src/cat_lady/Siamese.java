package cat_lady;


public class Siamese extends Cat {

    public double earSize;


    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return this.earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getClass().getSimpleName(),getName(), getEarSize());
    }
}
