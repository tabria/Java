package random_arraylist;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private Random rnd;

    public RandomArrayList(){
        rnd = new Random();
    }

    public Object getRandomElement(){

        int index = rnd.nextInt(super.size());
        Object obj = super.get(index);
        super.set(index, super.get(super.size()-1));
        super.remove(super.size()-1);

        return obj;
    }

}
