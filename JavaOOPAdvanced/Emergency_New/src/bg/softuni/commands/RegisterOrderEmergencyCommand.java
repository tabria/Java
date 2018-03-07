package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.factories.EmergencyFactory;
import bg.softuni.factories.RegistrationTimeFactory;

public class RegisterOrderEmergencyCommand extends BaseCommand {

    private static final String REGISTER_STRING = "Register";

    @InjectData
    private String[] data;

    public RegisterOrderEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {

        String emergencyDescription = this.data[1];
        String level = this.data[2];
        String time = this.data[3];
        String status = this.data[4];
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(level.toUpperCase());
        RegistrationTime registrationTime = RegistrationTimeFactory.create(time);
        Emergency emergency = EmergencyFactory.createOrderEmergency(emergencyDescription, emergencyLevel, registrationTime, status);

        return super.getManagementSystem().registerOrderEmergency(emergency);
    }
}
