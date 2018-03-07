package nfs;
import nfs.entities.Garage;
import nfs.entities.cars.Car;
import nfs.entities.races.Race;
import nfs.factories.CarFactory;
import nfs.factories.RaceFactory;

import java.util.*;

class CarManager {

    private Map<Integer, Car> carDb ;
    private Map<Integer, Race> raceDb ;
    private Garage garage;


    public CarManager() {
        this.carDb = new LinkedHashMap<>();
        this.raceDb = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    void register(int id, String type, String brand, String model,
                  int yearOfProduction, int horsepower, int acceleration,
                  int suspension, int durability) {
        Car car = CarFactory.create(type, brand, model, yearOfProduction,horsepower, acceleration, suspension, durability);
        if (car!=null){
            this.carDb.putIfAbsent(id, car);
        }
    }

    String check(int id) {
            return this.carDb.get(id).toString();
    }

    void open(int id, String type, int length, String route, int prizePool, int timeOrLap){
        this.raceDb.putIfAbsent(id, RaceFactory.create(type, length, route, prizePool, timeOrLap));
    }

    void open(int id, String type, int length, String route, int prizePool){
        Race race = RaceFactory.create(type, length, route, prizePool);
        if (race != null){
            this.raceDb.putIfAbsent(id,race);
        }
    }

    void participate(int carId, int raceId){
        if (!this.garage.getParkedCars().contains(this.carDb.get(carId)) && this.raceDb.containsKey(raceId)
                && this.carDb.containsKey(carId)){
             this.raceDb.get(raceId).addParticipant(this.carDb.get(carId));
        }
    }

    String start(int id){
        if (this.raceDb.containsKey(id) && this.raceDb.get(id).getParticipants().size()>0){
                return this.raceDb.remove(id).toString();
            }
        return "Cannot start the race with zero participants.";
    }

    void park(int id){
        if (this.carDb.containsKey(id)){
            for (Map.Entry<Integer, Race> race : this.raceDb.entrySet()) {
                if (race.getValue().getParticipants().contains(this.carDb.get(id))){
                    return;
                }
            }
            this.garage.addParkedCars(this.carDb.get(id));
        }
    }

    void unpark(int id){
        if (this.garage.getParkedCars().contains(this.carDb.get(id)) && this.carDb.containsKey(id)){
            this.garage.removeParkedCars(this.carDb.get(id));
        }
    }

    void tune(int tuneIndex, String addOn){
        if (this.garage.getParkedCars().size() > 0){
            this.garage.tune(tuneIndex, addOn);
        }
    }

}
