package nfs.entities.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
        setHorsepower(horsepower);
        setSuspension(suspension);
    }

    @Override
    public void setHorsepower(int horsepower) {
        super.setHorsepower(horsepower + (horsepower*50)/100);
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension(suspension - (suspension*25)/100);
    }


    @Override
    public void tuneCar(int tuneIndex, String addOn) {
        super.tuneCar(tuneIndex, addOn);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        return String.format("%sAdd-ons: %s%n", super.toString(),
                this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns));
    }
}
