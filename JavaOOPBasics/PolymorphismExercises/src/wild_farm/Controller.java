package wild_farm;

import wild_farm.entities.animal.Animal;
import wild_farm.entities.food.Food;

public class Controller {

    private static Food food= null;
    private static Animal animal = null;


    static void feedAnimal(String[] info, String[] infoFood, StringBuilder sb, StringBuilder sbSound){
            animal =  Factory.createMammal(info);
            food = Factory.createFood(infoFood);
            sbSound.append(animal.makeSound()).append(System.lineSeparator());

            try {
                animal.eat(food);
            } catch (IllegalArgumentException iae){
                sbSound.append(iae.getMessage()).append(System.lineSeparator());
            }

            sb.append(animal)
                .append(System.lineSeparator());

    }



}
