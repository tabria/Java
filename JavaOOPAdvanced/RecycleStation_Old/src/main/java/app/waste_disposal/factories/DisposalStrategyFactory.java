package app.waste_disposal.factories;

import app.waste_disposal.contracts.GarbageDisposalStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DisposalStrategyFactory {

    private static final String STRATEGY_PATH = "app.waste_disposal.models.strategies.";
    private static final String STRATEGY_SUFFIX = "Strategy";


    public static GarbageDisposalStrategy create(String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<GarbageDisposalStrategy> strategyType = (Class<GarbageDisposalStrategy>) Class.forName(STRATEGY_PATH + type + STRATEGY_SUFFIX);
        Constructor<GarbageDisposalStrategy> strategyCons = strategyType.getDeclaredConstructor();
        return strategyCons.newInstance();
    }

}

