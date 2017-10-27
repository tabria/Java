package raw_data;


import java.util.List;

public class Car {

    private String model;
    private Engine motor;
    private Cargo load;
    private List<Tire> tires;

    public Car(String model, Engine motor, Cargo load, List<Tire> tires) {
        this.model = model;
        this.motor = motor;
        this.load = load;
        this.tires = tires;
    }

    public String getLoadType() {
        return this.load.getCargoType();
    }

    public double getTirePressure(int index){
        return this.tires.get(index).getTirePressure();
    }

    public String getModel() {
        return this.model;
    }

    public int getEnginePower(){
        return this.motor.getEnginePower();
    }
}
