package ferrari;

public class Ferrari implements Car {

    private String model;
    private String driver;

    public Ferrari(String driver) {
        this.model = "488-Spider";
        this.driver = driver;
    }

    @Override
    public String pushBreaks() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return"Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.model, this.pushBreaks(),this.pushGas(), this.driver);
    }
}
