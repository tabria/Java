package vehicles2;

public class Car extends Vehicle {

    private final double EXTRA_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.addExtraFuelConsumption();
    }

    @Override
    protected void addExtraFuelConsumption() {
        super.setFuelConsumption(super.getFuelConsumption() + this.EXTRA_FUEL_CONSUMPTION);
    }

}
