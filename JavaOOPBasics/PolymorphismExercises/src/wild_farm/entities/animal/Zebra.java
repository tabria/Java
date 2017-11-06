package wild_farm.entities.animal;

import wild_farm.entities.food.Food;

import java.text.DecimalFormat;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "Zs";
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable")){
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(), super.getAnimalName(),
                new DecimalFormat("#.##").format(super.getAnimalWeight())
                ,super.getLivingRegion(), super.getFoodEaten());
    }
}
