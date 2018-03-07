package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import models.centers.EmergencyCenter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {

    private static final String COMMAND_PREFIX = "Register";
    private static final String CENTER_PATH = "models.centers.";

    @InjectArgs
    private String[] params;

    public RegisterMedicalServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String name = params[0].replace(COMMAND_PREFIX, "");
        Class<EmergencyCenter> centerClass = (Class<EmergencyCenter>) Class.forName(CENTER_PATH + name);
        Constructor<EmergencyCenter> centerConstructor = centerClass.getDeclaredConstructor(String.class, Integer.class);
        EmergencyCenter center = centerConstructor.newInstance(params[1], Integer.valueOf(params[2]));
        return super.getManagementSystem().registerMedicalServiceCenter(center);
    }
}
