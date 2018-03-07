package nfs.entities.races;

import nfs.entities.cars.Car;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car car) {
            return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());

    }
}
