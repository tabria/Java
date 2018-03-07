package nfs.entities.races;

import nfs.entities.cars.Car;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}
