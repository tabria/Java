package need_for_speed.core;

import need_for_speed.entitis.cars.Car;
import need_for_speed.entitis.garage.Garage;
import need_for_speed.entitis.races.Race;
import need_for_speed.factorie.CarFactory;
import need_for_speed.factorie.RaceFactory;
import need_for_speed.utilities.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {

        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();

    }

    public void register(int id, String type, String brand, String model, int
            yearOfProduction, int horsepower, int acceleration, int suspension, int
                            durability) {
        if (!this.cars.containsKey(id)){
            Car newCar = null;
            switch(type){
                case "Performance":
                    newCar = CarFactory.createPerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                    break;
                case "Show":
                    newCar = CarFactory.createShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            }
            if (newCar!= null){
                this.cars.putIfAbsent(id, newCar);
            }
        }
    }

    public String check(int id) {
        Car foundCar = this.cars.get(id);
        if (foundCar == null){
            return Constants.EMPTY_STRING;
        } else {
            return foundCar.toString();
        }
    }

    public void open(int id, String type, int length, String route, int prizePool){

        if (!this.races.containsKey(id)){
            Race newRace = null;
            switch (type){
                case "Casual":
                    newRace = RaceFactory.createCasualRace(length, route, prizePool);
                    break;
                case "Drag":
                    newRace = RaceFactory.createDragRace(length, route, prizePool);
                    break;
                case "Drift":
                    newRace = RaceFactory.createDriftRace(length, route, prizePool);
                    break;
            }

            if (newRace != null){
                this.races.putIfAbsent(id, newRace);
            }
        }
    }

    public void participate(int carId, int raceId){
        if (this.cars.containsKey(carId) && this.races.containsKey(raceId) && !this.garage.isParked(this.cars.get(carId)) && !this.races.get(raceId).getParticipants().contains(this.cars.get(carId))){
            this.races.get(raceId).addParticipant(this.cars.get(carId));
        }
    }

    public String start(int id) {

           if (this.races.containsKey(id) && this.races.get(id).getParticipants().size() != 0) {
               return this.races.remove(id).toString();
           }
           return Constants.RACE_PARTICIPANTS_NOT_PRESENT;

    }

    public void park(int id) {
        if (this.cars.containsKey(id)){
            for (Map.Entry<Integer, Race> race:this.races.entrySet()) {
                if (race.getValue().isParticipant(this.cars.get(id))){
                    return;
                }
            }
            this.garage.addParkedCar(this.cars.get(id));
        }

    }

    public void unpark(int id) {
        if (this.cars.containsKey(id)){
            Car car = cars.get(id);
            if (this.garage.isParked(car)){
                this.garage.upparkParkedCar(car);
            }
        }
    }

    public void tune(int tuneIndex, String addOn){
        if(this.garage.getParkedCars().size() != 0){
            this.garage.tune(tuneIndex, addOn);
        }
    }

}
