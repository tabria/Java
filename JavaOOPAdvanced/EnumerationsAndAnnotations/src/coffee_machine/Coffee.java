package coffee_machine;

public class Coffee {

    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(CoffeeSize size, CoffeeType type) {
        this.size = size;
        this.type = type;

    }

    public CoffeeSize getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.size.toString(), this.type.toString());
    }
}
