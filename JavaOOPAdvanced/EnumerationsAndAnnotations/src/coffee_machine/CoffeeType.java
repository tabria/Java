package coffee_machine;

public enum CoffeeType {

    ESPRESSO, LATTE, IRISH;


    @Override
    public String toString() {
        String lower = super.name().toLowerCase().substring(1);
        return super.name().charAt(0)+lower;
    }
}
