package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Car> cars = new LinkedHashMap<>();

        addCar(cars, reader);

        while(true){
            String[] command = reader.readLine().split("\\s+");
            if ("End".equals(command[0])){
                break;
            }
            Car currentCar = cars.get(command[1]);
            currentCar.adjustFuelAndDistance(Double.valueOf(command[2]));
            cars.put(command[1], currentCar);
        }

        cars.entrySet().stream().forEach(kv-> {
            System.out.printf("%s %.2f %.0f%n", kv.getKey(), kv.getValue().getFuelAmount(), kv.getValue().getDistance());
        });

    }

    private static void addCar(Map<String, Car> cars, BufferedReader reader) throws IOException {
        int cycles =Integer.valueOf(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] carInfo = reader.readLine().split("\\s+");
            if (!cars.containsKey(carInfo[0])){
                Car newCar = new Car(carInfo[0], Double.valueOf(carInfo[1]), Double.valueOf(carInfo[2]));
                cars.put(carInfo[0], newCar);
            }
        }
    }

}
