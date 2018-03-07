package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.EmergencyCenter;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.factories.EmergencyCenterFactory;

public class ProcessEmergenciesCommand extends BaseCommand {

    private static final String REGISTER_STRING = "Register";

    @InjectData
    private String[] data;

    public ProcessEmergenciesCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {

        String type = this.data[1];


        return super.getManagementSystem().processEmergencies(type);
    }
}
