package bg.softuni.factories;

import bg.softuni.contracts.EmergencyCenter;
import bg.softuni.models.centers.FiremanServiceCenter;
import bg.softuni.models.centers.MedicalServiceCenter;
import bg.softuni.models.centers.PoliceServiceCenter;

public final class EmergencyCenterFactory {

    public static EmergencyCenter createFireServiceCenter(String name, Integer amountOfEmergencies){
        return new FiremanServiceCenter(name, amountOfEmergencies);
    }

    public static EmergencyCenter createMedicalServiceCenter(String name, Integer amountOfEmergencies){
        return new MedicalServiceCenter(name, amountOfEmergencies);
    }

    public static EmergencyCenter createPoliceServiceCenter(String name, Integer amountOfEmergencies){
        return new PoliceServiceCenter(name, amountOfEmergencies);
    }

}
