package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.annotations.InjectEngine;
import app.waste_disposal.contracts.Manageble;
import app.waste_disposal.engines.Engine;
import app.waste_disposal.factories.ManagebleFactory;
import app.waste_disposal.models.ManagebleImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ChangeManagementRequirementCommand extends BaseCommand{

    private static final String MANAGEBLE_FIELD = "manageble";

    @Inject
    private String[] data;
    @InjectEngine
    private Engine engine;


    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        double requiredEnergy = Double.parseDouble(this.data[0]);
        double requiredCapital = Double.parseDouble(this.data[1]);
        String garbageType = this.data[2];

        Manageble newManageble = ManagebleFactory.create(requiredEnergy, requiredCapital, garbageType);

        Field managebleField = this.engine.getClass().getDeclaredField(MANAGEBLE_FIELD);
        managebleField.setAccessible(true);
        //Map<String, Manageble> engineManageble = (Map<String, Manageble>) managebleField.get(this.engine);
        //engineManageble.put(garbageType, newManageble);
        managebleField.set(this.engine, newManageble);

        return "Management requirement changed!";
    }

}
