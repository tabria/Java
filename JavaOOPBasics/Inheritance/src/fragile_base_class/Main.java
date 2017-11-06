package fragile_base_class;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predator predator = new Predator();
        predator.feed(new Food());
        predator.feedAll(new Food[] {new Food(), new Food(), new Food()});

    }


}
