package nfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CarManager carManager = new CarManager();

        while(true){
            String[] gameInput = reader.readLine().split("\\s+");
            if ("Cops".equals(gameInput[0]) && "Are".equals(gameInput[1]) && "Here".equals(gameInput[2])){
                break;
            }
            switch(gameInput[0]){
                case "register":
                    carManager.register(Integer.parseInt(gameInput[1]), gameInput[2], gameInput[3],
                            gameInput[4], Integer.parseInt(gameInput[5]), Integer.parseInt(gameInput[6]),
                            Integer.parseInt(gameInput[7]), Integer.parseInt(gameInput[8]), Integer.parseInt(gameInput[9]));
                    break;
                case "check":
                    System.out.print(carManager.check(Integer.parseInt(gameInput[1])));
                    break;
                case "open":
                    if (gameInput.length == 7){
                        carManager.open(Integer.parseInt(gameInput[1]), gameInput[2], Integer.parseInt(gameInput[3]),
                                gameInput[4], Integer.parseInt(gameInput[5]), Integer.parseInt(gameInput[6]));
                    } else {
                        carManager.open(Integer.parseInt(gameInput[1]), gameInput[2], Integer.parseInt(gameInput[3]),
                                gameInput[4], Integer.parseInt(gameInput[5]));
                    }
                    break;
                case "participate":
                    carManager.participate(Integer.parseInt(gameInput[1]), Integer.parseInt(gameInput[2]));
                    break;
                case "start":
                    System.out.print(carManager.start(Integer.parseInt(gameInput[1])));
                    break;
                case "park":
                    carManager.park(Integer.parseInt(gameInput[1]));
                    break;
                case "unpark":
                    carManager.unpark(Integer.parseInt(gameInput[1]));
                    break;
                case "tune":
                    carManager.tune(Integer.parseInt(gameInput[1]), gameInput[2]);
                    break;
            }
        }
    }

}
