package car_salesman;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new LinkedList<>();

        addEngine(engines, reader);
        addCars(cars, engines, reader);

        for (Car car: cars) {
            System.out.println(car);
        }
    }


    private static void addCars(List<Car> cars, List<Engine> engines, BufferedReader reader) throws IOException {
        int carCycles = Integer.valueOf(reader.readLine());
        for (int i = 0; i <carCycles ; i++) {
            String [] carInfo = reader.readLine().split("\\s+");
            String carModel = carInfo[0];
            String carEngineName = carInfo[1];
            Engine carEngine = getCarEngine(engines, carEngineName);

            int carWeight = getFirstOptionalElement(carInfo);
            boolean isWeight = carWeight!=Integer.MAX_VALUE;

            String carColor = getSecondOptionalElement(carInfo);
            boolean isColor = !carColor.equals("n/a");

            Car newCar = createCat(isWeight, isColor, carModel, carEngine, carWeight, carColor);
            cars.add(newCar);
        }

    }

    private static Car createCat(boolean isWeight, boolean isColor, String carModel, Engine carEngine, int carWeight, String carColor) {
        if (isWeight && isColor){
            return new Car(carModel, carEngine, carWeight, carColor);
        } else if (isWeight && !isColor){
            return new Car(carModel, carEngine, carWeight);
        } else if (!isWeight && isColor){
            return new Car(carModel, carEngine, carColor);
        } else {
            return new Car(carModel, carEngine);
        }
    }

    private static Engine getCarEngine(List<Engine> engines, String carEngineName) {
        for (Engine motor : engines) {
            if (motor.getModel().equals(carEngineName)){
                return motor;
            }
        }
        return new Engine("n/a", -1);
    }

    private static void addEngine(List<Engine> engines, BufferedReader reader) throws IOException {
        int cycles = Integer.valueOf(reader.readLine());
        for (int i = 0; i <cycles ; i++) {
            String[] engineInfo = reader.readLine().split("\\s+");
            String engineModel = engineInfo[0];
            int power = Integer.valueOf(engineInfo[1]);

            int displacement = getFirstOptionalElement(engineInfo);
            boolean isDisplacement = displacement!=Integer.MAX_VALUE;

            String efficiency = getSecondOptionalElement(engineInfo);
            boolean isEfficiency = !efficiency.equals("n/a");

            Engine newEngine = createEngine(isDisplacement, isEfficiency, engineModel, power, displacement, efficiency);
            engines.add(newEngine);
        }

    }

    private static int getFirstOptionalElement(String[] engineInfo) {
        int firstOptionalElement = Integer.MAX_VALUE;
        try {
            firstOptionalElement = Integer.parseInt(engineInfo[2]);
        } catch (Exception e) {};
        return firstOptionalElement;
    }

    private static String getSecondOptionalElement(String[] inoutInfo) {
        String SecondOptionalElement = "n/a";
        if (inoutInfo.length>2){
            try {
                SecondOptionalElement = inoutInfo[inoutInfo.length-1];
                try {
                    int check = Integer.valueOf(SecondOptionalElement);
                    SecondOptionalElement = "n/a";
                } catch (Exception e) {}
            } catch (Exception e){};
        }
        return SecondOptionalElement;
    }

    private static Engine createEngine(boolean isDisplacement, boolean isEfficiency, String engineModel, int power, int displacement, String efficiency) {
        if (isDisplacement && isEfficiency){
            return new Engine(engineModel, power, displacement, efficiency);
        } else if (isDisplacement && !isEfficiency){
            return new Engine(engineModel, power, displacement);
        } else if (!isDisplacement && isEfficiency){
            return new Engine(engineModel, power, efficiency);
        } else {
            return new Engine(engineModel, power);
        }
    }

}
