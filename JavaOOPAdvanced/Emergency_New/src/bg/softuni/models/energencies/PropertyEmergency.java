package bg.softuni.models.energencies;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;


public class PropertyEmergency extends BaseEmergency {

    private Integer damage;

    public PropertyEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage) {
        super(description, emergencyLevel, registrationTime);
        this.damage = damage;
    }


    @Override
    public Integer getExtraProperty() {
        return this.damage;
    }
}
