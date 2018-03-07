package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class WasteFactory {

    private static final String WASTE_PATH = "app.waste_disposal.models.wastes.";

    public static Waste create(String name, double weight, double volumePerKg, String type) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Waste> waste = (Class<Waste>) Class.forName(WASTE_PATH + type);
        Constructor<Waste> wasteConstructor = waste.getDeclaredConstructor(String.class, double.class, double.class);
        return wasteConstructor.newInstance(name, weight, volumePerKg);
    }

}
