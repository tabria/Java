package nfs.entities.races;

import nfs.entities.cars.Car;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    private int getGoldTime() {
        return this.goldTime;
    }

    public int getPricePoolPercentage(int performance) {
        int percentage = 0;
        if (performance <= getGoldTime()){
            percentage = 100;
        } else if (performance <= getGoldTime() + 15){
            percentage = 50;
        } else if (percentage > getGoldTime() + 15){
            percentage = 30;
        }
        return percentage;
    }

    @Override
    protected int calculatePoints(Car car) {
        return 0;
    }
}
