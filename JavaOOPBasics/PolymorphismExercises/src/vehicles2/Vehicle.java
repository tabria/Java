package vehicles2;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0 ){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    double getFuelConsumption() {
        return this.fuelConsumption;
    }

    void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract void addExtraFuelConsumption();

    void drive(double distance){
        if (this.fuelQuantity < distance * this.getFuelConsumption()){
            throw new IllegalStateException(getClass().getSimpleName() + " needs refueling");
        }
        if (this.fuelQuantity == distance * this.getFuelConsumption()){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        this.setFuelQuantity(this.fuelQuantity - (distance * this.fuelConsumption) );
    }

    void refuel(double liters){
        if (liters <= 0){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > this.tankCapacity){
            throw new IllegalStateException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += liters;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), this.getFuelQuantity());
    }
}
