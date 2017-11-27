package mood_3.factories;

import mood_3.entities.Archangel;
import mood_3.entities.Demon;


public final class GameObjectFactory {

    public static Demon createDemon(String username, int level, double energy){
        return new Demon(username, level, energy);
    }

    public static Archangel createArchangel(String username, int level, int mana){
        return new Archangel(username, level, mana);
    }
}
