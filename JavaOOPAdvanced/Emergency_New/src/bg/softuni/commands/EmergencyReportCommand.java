package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.ManagementSystem;

public class EmergencyReportCommand extends BaseCommand {


    public EmergencyReportCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {


        return super.getManagementSystem().emergencyReport();
    }
}
