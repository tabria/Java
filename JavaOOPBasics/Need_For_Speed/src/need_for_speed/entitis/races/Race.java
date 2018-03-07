package need_for_speed.entitis.races;

import need_for_speed.entitis.cars.Car;
import need_for_speed.utilities.Constants;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Race {
    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;


    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.participants = new LinkedList<>();
    }

    public int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return this.route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    public int getPrizePool() {
        return this.prizePool;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public void addParticipant(Car car){
        this.participants.add(car);
    }

    public boolean isParticipant(Car car){
        return this.participants.contains(car);
    }

    private Map<Integer, Car> getWinners(){
        Map<Integer, Car> cars = new HashMap<>() ;
        final int[] position = {1};
        this.participants.stream()
                .sorted((c1, c2) -> Integer.compare(this.calculatePoints(c2), this.calculatePoints(c1)))
                .limit(3)
                .forEach(c->cars.putIfAbsent(position[0]++, c));
        return cars;
    }

   protected abstract int calculatePoints(Car carParticipant);

    private int calculatePrize(int position) {
        int prize = 0;
        switch (position){
            case 1:
                prize = (this.prizePool * Constants.NORMAL_RACE_PRIZE_WINNER_PERCENTAGE) / Constants.PERCENTAGE;
                break;
            case 2:
                prize = (this.prizePool * Constants.NORMAL_RACE_PRIZE_SECOND_PLACE_PERCENTAGE) / Constants.PERCENTAGE;
                break;
            case 3:
                prize = (this.prizePool * Constants.NORMAL_RACE_PRIZE_THIRD_PLACE_PERCENTAGE) / Constants.PERCENTAGE;
                break;
        }

        return prize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %d%n",this.getRoute(),this.getLength()));
        for (Map.Entry<Integer, Car> carEntry : this.getWinners().entrySet()) {
            int prize = calculatePrize(carEntry.getKey());
            sb.append(String.format("%d. %s %s %dPP - $%d%n", carEntry.getKey(), carEntry.getValue().getBrand(), carEntry.getValue().getModel(), this.calculatePoints(carEntry.getValue()), prize));
        }
        return sb.toString() ;
    }


}
