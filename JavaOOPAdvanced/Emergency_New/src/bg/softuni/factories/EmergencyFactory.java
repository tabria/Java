package bg.softuni.factories;

import bg.softuni.contracts.Emergency;
import bg.softuni.contracts.RegistrationTime;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.energencies.HealthEmergency;
import bg.softuni.models.energencies.OrderEmergency;
import bg.softuni.models.energencies.PropertyEmergency;

public final class EmergencyFactory {


    public static Emergency createRegistrationEmergency(String emergencyDescription, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage){
        return new PropertyEmergency(emergencyDescription, emergencyLevel, registrationTime, damage);
    }

    public static Emergency createHealthEmergency(String emergencyDescription, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, Integer damage){
        return new HealthEmergency(emergencyDescription, emergencyLevel, registrationTime, damage);
    }

    public static Emergency createOrderEmergency(String emergencyDescription, EmergencyLevel emergencyLevel, RegistrationTime registrationTime, String status){
        return new OrderEmergency(emergencyDescription, emergencyLevel, registrationTime, status);
    }

}
