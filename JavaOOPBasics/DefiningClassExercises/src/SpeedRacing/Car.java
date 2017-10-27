package SpeedRacing;


public class Car {

    private String model;
    private double fuelAmount;
    private double fuelPerKm;
    private double distance;

    public Car(String model, double fuelAmount, double fuelCostForKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelCostForKm;
        this.distance = 0;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelPerKm() {
        return this.fuelPerKm;
    }


    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double calculateFuelToTravel(double distance){
        return distance * this.fuelPerKm;
    }

    public boolean isEnoughFuel(double distance){
        return this.fuelAmount >= this.calculateFuelToTravel(distance);
    }

    public void adjustFuelAndDistance (double distance){
        if (this.isEnoughFuel(distance)){
            setFuelAmount(getFuelAmount()-this.calculateFuelToTravel(distance));
            setDistance(getDistance() + distance);
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
