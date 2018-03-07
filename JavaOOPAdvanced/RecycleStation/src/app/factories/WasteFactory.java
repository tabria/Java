package app.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class WasteFactory {

    private static final String WASTE_PATH = "app.entities.";
    private static final String WASTE_SUFFIX = "Waste";

    private static Map<Class, Class> mapper = new LinkedHashMap<Class, Class>() {{
        put(int.class, Integer.class);
        put(long.class, Long.class);
        put(float.class, Float.class);
        put(double.class, Double.class);
    }};

    public static Waste create(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = args[args.length-1];
        Class<Waste> wasteClass = (Class<Waste>) Class.forName(WASTE_PATH + name + WASTE_SUFFIX);
        Constructor<Waste> wasteConstructor = (Constructor<Waste>) wasteClass.getDeclaredConstructors()[0];

        Class<?>[] wasteConstructorParameterTypes = wasteConstructor.getParameterTypes();
        Object[] wasteArguments = new Object[wasteConstructorParameterTypes.length];

        for (int i = 0; i < wasteConstructorParameterTypes.length ; i++) {
            Class<?> parameterType = wasteConstructorParameterTypes[i].isPrimitive() ? getWrapper(wasteConstructorParameterTypes[i])  : wasteConstructorParameterTypes[i];
            Constructor<?> parameterConstructor = parameterType.getConstructor(String.class);
            wasteArguments[i] = parameterConstructor.newInstance(args[i]);
        }
        return wasteConstructor.newInstance(wasteArguments);

    }

    private static Class<?> getWrapper(Class<?> wasteConstructorParameterType) {
       return mapper.get(wasteConstructorParameterType);
    }

}
