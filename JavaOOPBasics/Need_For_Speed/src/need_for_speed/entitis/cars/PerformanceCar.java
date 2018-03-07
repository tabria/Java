package need_for_speed.entitis.cars;

import need_for_speed.utilities.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
        this.modifyCar();

    }

    private void modifyCar() {
        this.setHorsepower(this.getHorsepower() + (this.getHorsepower() * Constants.HORSEPOWER_MODIFIER_VALUE) / Constants.PERCENTAGE);
        this.setSuspension(this.getSuspension() - (this.getSuspension() * Constants.SUSPENSION_MODIFIER_VALUE) / Constants.PERCENTAGE);
    }

    private List<String> getAddOns() {
        return Collections.unmodifiableList(this.addOns);
    }


    @Override
    public void tuneCar(int tuneIndex, String addOns) {
        super.tuneCar(tuneIndex, addOns);
        this.addOns.add(addOns);
    }

    @Override
    public String toString() {
        String addons = this.getAddOns().size()>0 ? String.join(", ", this.getAddOns()) : "None";
        return String.format("%sAdd-ons: %s\r\n", super.toString(),addons);
    }
}
