package nfs.entities.races;

import nfs.entities.cars.Car;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration();
    }
}
