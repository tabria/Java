package bg.softuni.models.energencies;

import bg.softuni.contracts.Emergency;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.contracts.RegistrationTime;

public abstract class BaseEmergency implements Emergency {
    private String description;

    private EmergencyLevel emergencyLevel;

    private RegistrationTime registrationTime;

    protected BaseEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime) {
        this.setDescription(description);
        this.setEmergencyLevel(emergencyLevel);
        this.setRegistrationTime(registrationTime);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public EmergencyLevel getEmergencyLevel() {
        return emergencyLevel;
    }

    @Override
    public RegistrationTime getRegistrationTime() {
        return registrationTime;
    }



    private void setDescription(String description) {
        this.description = description;
    }

    private void setEmergencyLevel(EmergencyLevel emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }

    private void setRegistrationTime(RegistrationTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
