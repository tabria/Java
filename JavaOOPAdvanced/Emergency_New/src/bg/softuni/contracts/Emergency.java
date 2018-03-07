package bg.softuni.contracts;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;

public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();

    Integer getExtraProperty();
}
