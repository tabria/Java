package models.emergencies;

import enums.EmergencyLevel;
import utils.RegistrationTime;

public interface Emergency {

    String getDescription();
    EmergencyLevel getEmergencyLevel();
    RegistrationTime getRegistrationTime();
    void setExtraProperty(String text);
    Integer getExtraProperty();

}
