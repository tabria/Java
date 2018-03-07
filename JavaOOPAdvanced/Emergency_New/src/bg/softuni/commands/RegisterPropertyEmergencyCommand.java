package bg.softuni.commands;

import bg.softuni.annotations.InjectData;
import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.Executable;
import bg.softuni.contracts.ManagementSystem;
import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.factories.EmergencyFactory;
import bg.softuni.factories.RegistrationTimeFactory;
import bg.softuni.utils.RegistrationTimeImpl;

public class RegisterPropertyEmergencyCommand extends BaseCommand {

    private static final String REGISTER_STRING = "Register";

    @InjectData
    private String[] data;

    public RegisterPropertyEmergencyCommand(ManagementSystem managementSystem) {
        super(managementSystem);
    }


    @Override
    public String execute() {

        String emergencyDescription = this.data[1];
        String level = this.data[2];
        String time = this.data[3];
        Integer damage = Integer.parseInt(this.data[4]);
        EmergencyLevel emergencyLevel = EmergencyLevel.valueOf(level.toUpperCase());
        RegistrationTime registrationTime = RegistrationTimeFactory.create(time);
        Emergency emergency = EmergencyFactory.createRegistrationEmergency(emergencyDescription, emergencyLevel, registrationTime, damage);

        return super.getManagementSystem().registerPropertyEmergency(emergency);
    }
}
