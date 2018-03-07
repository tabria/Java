package need_for_speed.entitis.races;

import need_for_speed.entitis.cars.Car;

public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car carParticipant) {
        int horsepower = carParticipant.getHorsepower();
        int acceleration = carParticipant.getAcceleration();

        return (horsepower / acceleration);
    }
}
