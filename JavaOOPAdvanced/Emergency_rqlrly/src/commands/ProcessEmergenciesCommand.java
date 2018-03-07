package commands;

import annotations.InjectType;
import core.ManagementSystem;

import java.lang.reflect.InvocationTargetException;

public class ProcessEmergenciesCommand extends BaseCommand {

    @InjectType
    String type;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return super.getManagementSystem().processEmergencies(this.type);
    }
}
