package commands;

import annotations.InjectArgs;
import core.ManagementSystem;
import enums.EmergencyLevel;
import models.emergencies.Emergency;
import utils.RegistrationTime;
import utils.RegistrationTimeImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    private static final String COMMAND_PREFIX = "Register";
    private static final String EMERGENCY_MODEL_PATH = "models.emergencies.";

    @InjectArgs
    private String[] params;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String description = params[1];
        EmergencyLevel level = EmergencyLevel.valueOf(params[2].toUpperCase());
        RegistrationTime registrationTime = new RegistrationTimeImpl(params[3]);
        String name = params[0].replace(COMMAND_PREFIX, "");
        Class<Emergency> emergencyClass = (Class<Emergency>) Class.forName(EMERGENCY_MODEL_PATH + name);
        Constructor<Emergency> emergencyConstructor = emergencyClass.getDeclaredConstructor(String.class, EmergencyLevel.class, RegistrationTime.class, String.class);
        Emergency emergency = emergencyConstructor.newInstance(description, level, registrationTime, params[4]);
        return super.getManagementSystem().registerPropertyEmergency(emergency) ;
    }
}
