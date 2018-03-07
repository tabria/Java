package bg.softuni.models.energencies;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;


public class HealthEmergency extends BaseEmergency {

    private Integer casualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer casualties) {
        super(description, emergencyLevel, registrationTime);
        this.casualties = casualties;
    }


    @Override
    public Integer getExtraProperty() {
        return this.casualties;
    }
}
