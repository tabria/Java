package car_salesman;

public class Engine {

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency ="n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.displacement = "n/a";
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = String.valueOf(displacement);
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = String.valueOf(displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return " " + model + ":\r\n" +
                "  Power: " + power + "\r\n" +
                "  Displacement: " + displacement + "\r\n" +
                "  Efficiency: " + efficiency + "\r\n";
    }
}
