package fragile_base_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal {

    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public final void eatAll(Food[] foods){
        Collections.addAll(this.foodEaten, foods);
//        for (Food food:foods) {
//            this.eat(food);
//        }
    }

}
