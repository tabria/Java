package wild_farm.entities.animal;

import wild_farm.entities.food.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String makeSound() {
        return "Meowwww";
    }

    @Override
    public void eat(Food food) {
        if (!food.getClass().getSimpleName().equals("Vegetable") && !food.getClass().getSimpleName().equals("Meat")){
            throw new IllegalArgumentException("Cats are not eating that type of food!");
        }
        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]",
                getClass().getSimpleName(), super.getAnimalName(), this.breed,
                new DecimalFormat("#.##").format(super.getAnimalWeight())
                ,super.getLivingRegion(), super.getFoodEaten());
    }
}
