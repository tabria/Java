package paw_inc.factories;

import paw_inc.entities.animals.Cat;
import paw_inc.entities.animals.Dog;

public final class AnimalFactory {


    public static Dog createDog(String name, int age, int amountOfCommands){
        return new Dog(name, age, amountOfCommands);
    }

    public static Cat createCat(String name, int age, int intelligenceCoefficient){
        return new Cat(name, age, intelligenceCoefficient);
    }

}
