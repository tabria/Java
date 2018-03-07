package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class HealthEmergency extends BaseEmergency {

    private Integer casualties;

    public HealthEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String casualties) {
        super(description, emergencyLevel, registrationTime);
        this.setExtraProperty(casualties);
    }



    @Override
    public void setExtraProperty(String text) {
        this.casualties = Integer.valueOf(text);
    }

    @Override
    public Integer getExtraProperty() {
        return this.casualties;
    }
}