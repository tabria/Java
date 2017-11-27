package coffee_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        String line = "";
        while(!"END".equals(line = reader.readLine())){
            String[] coffeeInfo = line.split("\\s+");
            if (coffeeInfo.length<2){
                coffeeMachine.insertCoin(coffeeInfo[0]);
            } else {
                coffeeMachine.buyCoffee(coffeeInfo[0], coffeeInfo[1]);
            }
        }

        coffeeMachine.coffeesSold().forEach(System.out::println);

    }

}
