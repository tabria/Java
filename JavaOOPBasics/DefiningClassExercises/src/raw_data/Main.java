package raw_data;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> cars = new LinkedList<>();

        addCars(cars, reader);

        String command = reader.readLine();
        if ("fragile".equals(command)){
            cars.stream().filter(filterByCargoType(command)).filter(filterByTirePressure()).forEach(printCar());
        } else if("flamable".equals(command)){
            cars.stream().filter(filterByCargoType(command)).filter(y->y.getEnginePower()>250).forEach(printCar());
        }
    }

    private static Consumer<Car> printCar() {
        return c-> System.out.println(c.getModel());
    }

    private static Predicate<Car> filterByCargoType(String command) {
        return x-> x.getLoadType().equals(command);
    }

    private static Predicate<Car> filterByTirePressure() {
        return  y -> {
            for (int i = 0; i <3 ; i++) {
                double pressure = y.getTirePressure(i);
                if (pressure < 1){
                    return true;
                }
            }
            return false;
        };
    }

    private static void addCars(List<Car> cars, BufferedReader reader) throws IOException {
        int cycles = Integer.valueOf(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] carInfo = reader.readLine().split("\\s+");

            Engine carEngine = createEngine(carInfo);
            Cargo carCargo = createCargo(carInfo);
            List<Tire> carTires = new ArrayList<>();
            fillTireInfo(carTires, carInfo);

            String carModel = carInfo[0];
            Car currentCar = new Car(carModel, carEngine ,carCargo, carTires);
            cars.add(currentCar);
        }
    }

    private static void fillTireInfo(List<Tire> carTires, String[] carInfo) {
        for (int j = 5; j <carInfo.length ; j +=2) {
            double tirePressure = Double.valueOf(carInfo[j]);
            int tireAge = Integer.valueOf(carInfo[j+1]);
            Tire carTire = new Tire(tirePressure, tireAge);
            carTires.add(carTire);
        }
    }

    private static Cargo createCargo(String[] carInfo) {
        int cargoWeight = Integer.valueOf(carInfo[3]);
        String cargoType = carInfo[4];
        return new Cargo(cargoWeight, cargoType);
    }

    private static Engine createEngine(String[] carInfo) {
        int engineSpeed = Integer.valueOf(carInfo[1]);
        int enginePower = Integer.valueOf(carInfo[2]);
        return new Engine(engineSpeed, enginePower);
    }

}
