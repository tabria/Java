package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.EmergencyCenter;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.factories.EmergencyCenterFactory;
import bg.softuni.factories.EmergencyFactory;
import bg.softuni.factories.RegistrationTimeFactory;

public class RegisterFireServiceCenterCommand extends BaseCommand {

    private static final String REGISTER_STRING = "Register";

    @InjectData
    private String[] data;

    public RegisterFireServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {

        String name = this.data[1];
        Integer amountOfEmergencies = Integer.parseInt(this.data[2]);
        EmergencyCenter emergencyCenter = EmergencyCenterFactory.createFireServiceCenter(name, amountOfEmergencies);

        return super.getManagementSystem().registerFireServiceCenter(emergencyCenter);
    }
}
