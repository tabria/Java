package nfs.entities;

import nfs.entities.cars.Car;

import java.util.*;


public class Garage {

    private List<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public List<Car> getParkedCars() {
        return Collections.unmodifiableList(this.parkedCars);
    }

    public void removeParkedCars(Car car) {
        this.parkedCars.remove(car);
    }

    public void tune(int index, String addOn){
        this.parkedCars.forEach(c->c.tuneCar(index, addOn));
    }

    public void addParkedCars(Car car) {
        this.parkedCars.add(car);
    }
}
