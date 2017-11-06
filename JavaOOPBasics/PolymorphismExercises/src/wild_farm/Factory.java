package wild_farm;

import wild_farm.entities.animal.*;
import wild_farm.entities.food.Food;
import wild_farm.entities.food.Meat;
import wild_farm.entities.food.Vegetable;

public final class Factory {

    public static Animal createMammal(String[] info){
        switch(info[0]){
            case "Mouse":
                return new Mouse(info[1], info[0], Double.parseDouble(info[2]), info[3]);
            case "Zebra":
                return new Zebra(info[1], info[0], Double.parseDouble(info[2]), info[3]);
            case "Cat":
                return new Cat(info[1], info[0], Double.parseDouble(info[2]), info[3], info[4]);
            case "Tiger":
                return  new Tiger(info[1], info[0], Double.parseDouble(info[2]), info[3]);
                default:
                    return null;
        }
    }

    static Food createFood(String[] food){
        if (food[0].equals("Vegetable")){
            return new Vegetable(Integer.parseInt(food[1]));
        } else if (food[0].equals("Meat")){
            return new Meat(Integer.parseInt(food[1]));
        }
        return null;
    }

}
