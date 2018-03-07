package commands;

import core.ManagementSystem;

import java.lang.reflect.InvocationTargetException;

public class EmergencyReportCommand extends BaseCommand {

    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return super.getManagementSystem().emergencyReport() ;
    }
}
