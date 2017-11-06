package vehicles2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carInfo = reader.readLine().split("\\s+");
        Car newCar = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));

        String[] truckInfo = reader.readLine().split("\\s+");
        Truck newTruck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));

        String[] busInfo = reader.readLine().split("\\s+");
        Bus newBus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));

        DecimalFormat df = new DecimalFormat("#.##");

        int cycles = Integer.parseInt(reader.readLine());

        for (int i = 0; i <cycles ; i++) {
            String[] actionInfo = reader.readLine().split("\\s+");
            try {
                switch(actionInfo[0].toLowerCase()){
                    case "drive":
                        double distance = Double.parseDouble(actionInfo[2]);
                        if (actionInfo[1].toLowerCase().equals("car")){
                            newCar.drive(distance);
                        } else if (actionInfo[1].toLowerCase().equals("truck")) {
                            newTruck.drive(distance);
                        } else {
                            newBus.drivePassengers(distance);
                        }
                        System.out.println(actionInfo[1] + " travelled " + df.format(distance) + " km");
                        break;
                    case "refuel":
                        double liters = Double.parseDouble(actionInfo[2]);
                        if (actionInfo[1].toLowerCase().equals("car")){
                            newCar.refuel(liters);
                        } else if (actionInfo[1].toLowerCase().equals("truck")){
                            newTruck.refuel(liters);
                        } else {
                            newBus.refuel(liters);
                        }
                        break;
                    case "driveempty":
                            double driveDistance = Double.parseDouble(actionInfo[2]);
                            newBus.drive(driveDistance);
                            System.out.println(actionInfo[1] + " travelled " + df.format(driveDistance) + " km");
                        break;
                }
            } catch(IllegalStateException ise){
                System.out.println(ise.getMessage());
            }
        }
        System.out.println(newCar);
        System.out.println(newTruck);
        System.out.println(newBus);
    }

}
