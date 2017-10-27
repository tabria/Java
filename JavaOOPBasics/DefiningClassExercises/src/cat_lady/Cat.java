package cat_lady;

public abstract class Cat  {

    private String name;

    protected Cat(String name) {
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
