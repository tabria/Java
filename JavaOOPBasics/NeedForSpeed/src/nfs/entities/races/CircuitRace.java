package nfs.entities.races;

import nfs.entities.cars.Car;

public class CircuitRace extends Race {

    private int laps;

    public CircuitRace(int length, String route, int prizePool, int laps) {
        super(length, route, prizePool);
        this.laps = laps;
    }

    private int getLaps() {
        return this.laps;
    }

    public int getLength() {
        return super.getLength()*getLaps();
    }



    public int decreaseDurability(){
        return super.getLength() * this.getLength();
    }

    public int getPricePoolPercentage(int counter) {
        switch (counter){
            case 1:
                return 40;
            case 2:
                return 30;
            case 3:
                return 20;
            case 4:
                return 10;
            default:
                return 0;
        }
    }
    @Override
    protected int calculatePoints(Car car) {
        return 0;
    }
}
