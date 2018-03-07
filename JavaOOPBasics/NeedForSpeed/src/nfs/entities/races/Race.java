package nfs.entities.races;

import nfs.entities.cars.Car;

import java.util.*;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;

    Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedList<>();
    }

    public int getLength() {
        return this.length;
    }

    protected abstract int calculatePoints(Car car);

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public void addParticipant (Car car){
        this.participants.add(car);
    }

    private Map<Integer, Car> getWinners(){
        Map<Integer, Car> winners = new HashMap<>();
        final int[] position = {1};
        this.participants.stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1)))
                .limit(3)
                .forEach(c-> winners.putIfAbsent(position[0]++, c));
        return winners;
    }

    private int getPrizeWon(int position) {
        switch (position){
            case 1:
                return (this.prizePool * 50) /100;
            case 2:
                return (this.prizePool * 30) /100;
            case 3:
                return (this.prizePool * 20) /100;
            default:
                    return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s%n", this.route, this.length));
        for (Map.Entry<Integer, Car> carEntry : this.getWinners().entrySet()){
            int position = carEntry.getKey();
            int prize = this.getPrizeWon(position);
            Car car = carEntry.getValue();
            sb.append(String.format("%d. %s %s %dPP - $%d%n",position, car.getBrand(), car.getModel(), this.calculatePoints(car),prize));
        }

        return sb.toString();
    }
}


