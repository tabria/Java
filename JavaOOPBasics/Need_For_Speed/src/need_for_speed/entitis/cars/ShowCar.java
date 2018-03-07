package need_for_speed.entitis.cars;

import need_for_speed.utilities.Constants;

public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setStars(Constants.STARS_DEFAULT_VALUE);
    }

    private int getStars() {
        return this.stars;
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public void tuneCar(int tuneIndex, String addOns) {
        super.tuneCar(tuneIndex, addOns);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        return String.format("%s%d *%n", super.toString(),this.getStars());
    }
}
