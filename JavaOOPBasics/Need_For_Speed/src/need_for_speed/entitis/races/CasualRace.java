package need_for_speed.entitis.races;

import need_for_speed.entitis.cars.Car;

public class CasualRace extends Race {

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    protected int calculatePoints(Car carParticipant) {
        int horsepower = carParticipant.getHorsepower();
        int acceleration = carParticipant.getAcceleration();
        int suspension = carParticipant.getSuspension();
        int durability = carParticipant.getDurability();

        return (horsepower / acceleration) + (suspension + durability);
    }
}
