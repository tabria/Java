package wild_farm.entities.animal;

import wild_farm.entities.food.Food;

import java.text.DecimalFormat;

public class Tiger extends Felime {

    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }

    @Override
    public String makeSound() {
        return "ROAAR!!!";
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getClass().getSimpleName(), super.getAnimalName(),
                new DecimalFormat("#.##").format(super.getAnimalWeight())
                ,this.livingRegion, super.getFoodEaten());
    }
}
