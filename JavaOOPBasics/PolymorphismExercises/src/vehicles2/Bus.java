package vehicles2;

public class Bus extends Vehicle {

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void addExtraFuelConsumption() {

    }


    public void drivePassengers(double distance) {
        if (super.getFuelQuantity() < distance * (super.getFuelConsumption() + 1.4)){
            throw new IllegalStateException(getClass().getSimpleName() + " needs refueling");
        }
        if (super.getFuelQuantity() == distance * (super.getFuelConsumption()+1.4)){
            throw new IllegalStateException("Fuel must be a positive number");
        }
        super.setFuelQuantity(super.getFuelQuantity() - (distance * (super.getFuelConsumption() + 1.4) ));
    }
}
