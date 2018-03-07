package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class PropertyEmergency extends BaseEmergency {

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String damage) {
        super(description, emergencyLevel, registrationTime);
        this.setExtraProperty(damage);
    }
    @Override
    public void setExtraProperty(String text){
            this.damage = Integer.valueOf(text);
    }

    @Override
    public Integer getExtraProperty() {
        return this.damage;
    }
}