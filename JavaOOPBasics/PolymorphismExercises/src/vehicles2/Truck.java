package vehicles2;

public class Truck extends Vehicle {

    private final double EXTRA_FUEL_CONSUMPTION = 1.6;
    private final double FUEL_LOSSES = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.addExtraFuelConsumption();
    }

    @Override
    protected void addExtraFuelConsumption() {
        super.setFuelConsumption(super.getFuelConsumption() + this.EXTRA_FUEL_CONSUMPTION);
    }

    @Override
    void refuel(double liters) {
       super.refuel(liters * FUEL_LOSSES);
    }

//    void refuel(double liters) {
//        super.setFuelQuantity(super.getFuelQuantity() + liters * FUEL_LOSSES);
//    }
}
