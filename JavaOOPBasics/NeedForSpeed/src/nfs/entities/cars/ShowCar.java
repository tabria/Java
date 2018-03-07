package nfs.entities.cars;

public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars =0;
    }

    private int getStars() {
        return this.stars;
    }

    @Override
    public void tuneCar(int tuneIndex, String addOn) {
        super.tuneCar(tuneIndex, addOn);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%d *%n", this.getStars());
    }
}
