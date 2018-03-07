package hell.factories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HeroFactory {

    private static final String HERO_PATH = "hell.entities.heroes.";


    public static <T> T createHero(String name, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<T> heroClass = (Class<T>) Class.forName(HERO_PATH + type);
        Constructor<T> heroConstructor = heroClass.getDeclaredConstructor(String.class);

        return heroConstructor.newInstance(name);
    }
}
