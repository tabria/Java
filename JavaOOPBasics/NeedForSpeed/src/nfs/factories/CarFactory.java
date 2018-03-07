package nfs.factories;

import nfs.entities.cars.Car;
import nfs.entities.cars.PerformanceCar;
import nfs.entities.cars.ShowCar;

public final class CarFactory {

    public static Car create(String type, String brand, String model,
                       int yearOfProduction, int horsepower, int acceleration,
                       int suspension, int durability){
        Car car = null;
        switch(type){
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction,
                        horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car =  new ShowCar(brand, model, yearOfProduction,
                        horsepower, acceleration, suspension, durability);
                break;
                default:
                    return null;
        }
        return car;
    }

}
