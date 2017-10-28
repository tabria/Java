package pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private static final String STRING_DEFAULT = "";

    private String name;
    private Dough dough;
    private List<Topping> toppings;


    public Pizza() {
        this.name =STRING_DEFAULT;
        this.dough = null;
        this.toppings = new ArrayList<>();
    }

    void setName(String name) {
        if (name.isEmpty() || name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    void checkToppings(int quantity) {
        if (quantity > 10 || quantity < 0){
            throw  new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setAddedTopping(Topping topping){
        this.toppings.add(topping);
    }

    void addTopping(Topping topping){
        setAddedTopping(topping);
    }

    private double calculateToppingCalories(){
        double toppingCalories = 0.0;
        for (Topping tops : this.toppings) {
            toppingCalories += tops.getModifier()*(2*tops.getWeight());
        }
        return  toppingCalories;
    }

    private double calculateDoughCalories(){
        return 2 * this.dough.getWeight() * this.dough.getModifierFlower() * this.dough.getModifierTechnic();
    }

    private double calculateTotalCalories(){
        return calculateDoughCalories() + calculateToppingCalories();
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", name, calculateTotalCalories());
    }
}
