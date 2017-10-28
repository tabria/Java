package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Pizza newPizza = new Pizza();
            Dough newDough = new Dough();
            while(true){
                String[] pizzaInfo = reader.readLine().split("\\s+");
                if("END".equals(pizzaInfo[0])){
                    break;
                }
                switch(pizzaInfo[0].toLowerCase()){
                    case "pizza":
                        newPizza.setName(pizzaInfo[1]);
                        newPizza.checkToppings(Integer.parseInt(pizzaInfo[2]));
                        break;
                    case "dough":
                        newDough.setFlowerType(pizzaInfo[1]);
                        newDough.setDoughTechnic(pizzaInfo[2]);
                        newDough.setWeight(Double.parseDouble(pizzaInfo[3]));
                        newPizza.setDough(newDough);
                        break;
                    case "topping":
                        Topping newTopping = new Topping(pizzaInfo[1], Double.parseDouble(pizzaInfo[2]));
                        newPizza.addTopping(newTopping);
                        break;
                }
            }
            System.out.println(newPizza);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
