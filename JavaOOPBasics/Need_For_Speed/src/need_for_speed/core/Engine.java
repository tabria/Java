package need_for_speed.core;

import need_for_speed.utilities.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {

    private CarManager carManager;

    public Engine() {

        this.carManager = new CarManager();
    }

    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = reader.readLine();
            if (Constants.TERMINATE_COMMAND.equals(input)){
                break;
            }
            String[] commands = input.split("\\s+");

            this.dispatcher(commands);
        }
    }

    private void dispatcher(String[] commands){

        switch (commands[0]){
            case "register":
                int carId = Integer.parseInt(commands[1]);

                String carType = commands[2];
                String carBrand = commands[3];
                String carModel = commands[4];

                int carYearOfProduction = Integer.parseInt(commands[5]);
                int carHorsePower = Integer.parseInt(commands[6]);
                int carAcceleration = Integer.parseInt(commands[7]);
                int carSuspension = Integer.parseInt(commands[8]);
                int carDurability = Integer.parseInt(commands[9]);

                this.carManager.register(carId, carType, carBrand, carModel, carYearOfProduction, carHorsePower, carAcceleration, carSuspension, carDurability);
                break;

            case "check":
                int id = Integer.parseInt(commands[1]);
                String output = this.carManager.check(id);
                if(!output.isEmpty()){
                    System.out.print(output);
                }
                break;

            case "open":
                int raceId = Integer.parseInt(commands[1]);
                String raceType = commands[2];
                int raceLength = Integer.parseInt(commands[3]);
                String raceRoute = commands[4];
                int racePrize = Integer.parseInt(commands[5]);

                this.carManager.open(raceId, raceType, raceLength, raceRoute, racePrize);
                break;
            case "participate":
                int carID = Integer.parseInt(commands[1]);
                int raceID = Integer.parseInt(commands[2]);

                this.carManager.participate(carID, raceID);
                break;
            case "start":
                int startRaceId = Integer.parseInt(commands[1]);
                String result = this.carManager.start(startRaceId);
                if (!result.isEmpty()){
                    System.out.print(result);
                }
                break;
            case "park":
                int parkCarId = Integer.parseInt(commands[1]);
                this.carManager.park(parkCarId);
                break;
            case "unpark":
                int unparkId = Integer.parseInt(commands[1]);
                this.carManager.unpark(unparkId);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commands[1]);
                String addon = commands[2];
                this.carManager.tune(tuneIndex, addon);
                break;
        }
    }
}
