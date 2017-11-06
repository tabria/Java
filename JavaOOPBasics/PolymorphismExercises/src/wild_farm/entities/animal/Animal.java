package wild_farm.entities.animal;

import wild_farm.entities.food.Food;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;


    public Animal(String animalName, String animalType, double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }


    void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    String getAnimalName() {
        return this.animalName;
    }

    double getAnimalWeight() {
        return this.animalWeight;
    }

    int getFoodEaten() {
        return this.foodEaten;
    }
    public abstract String makeSound();
    public abstract void eat(Food food);

}
