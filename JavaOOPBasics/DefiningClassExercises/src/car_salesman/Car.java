package car_salesman;

public class Car {

    private String model;
    private Engine motor;
    private String weight;
    private String color;

    public Car(String model, Engine motor) {
        this.model = model;
        this.motor = motor;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine motor, String color) {
        this.model = model;
        this.motor = motor;
        this.weight ="n/a";
        this.color = color;

    }

    public Car(String model, Engine motor, int weight) {
        this(model, motor);
        this.weight = String.valueOf(weight);;
        this.color = "n/a";
    }

    public Car(String model, Engine motor, int weight, String color) {
        this(model, motor);
        this.weight = String.valueOf(weight);
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getMotor() {
        return this.motor;
    }

    public String getEngineType(){
        return this.motor.getModel();
    }

    public int getEnginePower(){
        return this.motor.getPower();
    }

    @Override
    public String toString() {
        return model + ":\r\n" +
                motor +
                "Weight: " + weight + "\r\n" +
                "Color: " + color;
    }
}
