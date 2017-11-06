package fragile_base_class;

import java.util.ArrayList;

public class Predator extends Animal {

    private int health;

    public Predator() {
        super();
        this.health = 0;
    }

    public void feed(Food food){
        super.eat(food);
        health++;
    }

    public void feedAll(Food[] foods){
        super.eatAll(foods);
        this.health += foods.length;
    }

//    @Override
//    public void eat(Food food) {
//        super.eat(food);
//        health++;
//    }
}
