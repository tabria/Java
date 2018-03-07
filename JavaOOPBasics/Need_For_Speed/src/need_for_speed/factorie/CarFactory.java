package need_for_speed.factorie;

import need_for_speed.entitis.cars.PerformanceCar;
import need_for_speed.entitis.cars.ShowCar;

public final class CarFactory {

    public static PerformanceCar createPerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability){
        return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public static ShowCar createShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

}
