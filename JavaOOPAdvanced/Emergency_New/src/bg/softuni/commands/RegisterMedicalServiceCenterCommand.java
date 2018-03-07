package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.EmergencyCenter;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.factories.EmergencyCenterFactory;

public class RegisterMedicalServiceCenterCommand extends BaseCommand {

    private static final String REGISTER_STRING = "Register";

    @InjectData
    private String[] data;

    public RegisterMedicalServiceCenterCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {

        String name = this.data[1];
        Integer amountOfEmergencies = Integer.parseInt(this.data[2]);
        EmergencyCenter emergencyCenter = EmergencyCenterFactory.createMedicalServiceCenter(name, amountOfEmergencies);

        return super.getManagementSystem().registerMedicalServiceCenter(emergencyCenter);
    }
}
