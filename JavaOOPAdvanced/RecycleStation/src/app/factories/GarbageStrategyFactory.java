package app.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GarbageStrategyFactory {

    private static final String STRATEGY_PATH = "app.entities.strategies.";
    private static final String STRATEGY_SUFFIX = "Strategy";

    private static Map<Class, Class> mapper = new LinkedHashMap<Class, Class>(){{
        put(int.class, Integer.class);
        put(long.class, Long.class);
        put(float.class, Float.class);
        put(double.class, double.class);
    }};

    public static GarbageDisposalStrategy create(String... args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String strategyName = args[args.length-1];
        Class<GarbageStrategyFactory> strategyFactoryClass = (Class<GarbageStrategyFactory>) Class.forName(STRATEGY_PATH +  strategyName + STRATEGY_SUFFIX);
        Constructor<GarbageStrategyFactory> strategyConstructor = (Constructor<GarbageStrategyFactory>) strategyFactoryClass.getDeclaredConstructors()[0];

        Class<?>[] parameterTypes = strategyConstructor.getParameterTypes();

        Object[] strategyParameters = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameter = parameterTypes[i].isPrimitive() ? getWrapper(parameterTypes[i]) : parameterTypes[i];
            Constructor<?> parameterConstructor = parameter.getDeclaredConstructor(String.class);
            strategyParameters[i] = parameterConstructor.newInstance(args[i]);
        }

        return (GarbageDisposalStrategy) strategyConstructor.newInstance(strategyParameters);
    }

    private static Class<?> getWrapper(Class<?> parameterType) {
        return mapper.get(parameterType);
    }

}
