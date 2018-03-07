package need_for_speed.entitis.garage;

import need_for_speed.entitis.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public void addParkedCar(Car car){
        this.parkedCars.add(car);
    }

    public void upparkParkedCar(Car car){
        this.parkedCars.remove(car);
    }

    public boolean isParked(Car car){
        return this.getParkedCars().contains(car);
    }

    public void tune(int tuneIndex, String addOns){
        this.getParkedCars().forEach(c->c.tuneCar(tuneIndex, addOns));
    }

}
