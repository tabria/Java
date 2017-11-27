package coffee_machine;

public enum CoffeeSize {

    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int size;
    private int price;

    CoffeeSize(int size, int price) {
        this.size = size;
        this.price = price;
    }

    public int getSize() {
        return this.size;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String lower = super.name().toLowerCase().substring(1);
        return super.name().charAt(0) + lower;
    }
}
