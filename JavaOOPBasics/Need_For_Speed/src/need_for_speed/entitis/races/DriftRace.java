package need_for_speed.entitis.races;

import need_for_speed.entitis.cars.Car;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
     protected int calculatePoints(Car carParticipant) {
        int suspension = carParticipant.getSuspension();
        int durability = carParticipant.getDurability();

        return (suspension + durability);
    }
}
