package pet_clinics.factories;

import pet_clinics.entities.ClinicImpl;
import pet_clinics.interfaces.Clinic;

public final class ClinicFactory {


    public static Clinic createClinic(String name, int roomsCount){
        return new ClinicImpl(name, roomsCount);
    }

}
