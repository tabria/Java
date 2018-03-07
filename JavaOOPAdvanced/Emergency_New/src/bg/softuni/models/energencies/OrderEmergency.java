package bg.softuni.models.energencies;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;


public class OrderEmergency extends BaseEmergency {

    private static final String SPECIAL = "Special";

    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime);
        this.status = status;
    }

    @Override
    public Integer getExtraProperty() {
        return this.status.equals(SPECIAL) ? 1 : 0;
    }
}
