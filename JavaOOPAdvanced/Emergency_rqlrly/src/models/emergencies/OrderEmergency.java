package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public class OrderEmergency extends BaseEmergency {

    private static final String SPECIAL_STATUS = "Special";
    private static final String NON_SPECIAL_STATUS = "Non-Special";

    private String status;

    public OrderEmergency(String description, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status) {
        super(description, emergencyLevel, registrationTime);
        this.setExtraProperty(status);
    }

    @Override
    public void setExtraProperty(String text) {
        switch(text){
            case SPECIAL_STATUS:
                this.status = text;
                break;
            default:
                this.status = NON_SPECIAL_STATUS;
        }
    }

    @Override
    public Integer getExtraProperty() {
        if (this.status.equalsIgnoreCase(SPECIAL_STATUS)){
            return 1;
        } else {
            return 0;
        }
    }
}
