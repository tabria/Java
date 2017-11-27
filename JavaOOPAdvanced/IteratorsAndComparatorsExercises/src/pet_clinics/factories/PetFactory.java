package pet_clinics.factories;

import pet_clinics.interfaces.Pet;
import pet_clinics.entities.PetImpl;

public final class PetFactory {


    public static Pet createPet(String name, int age, String kind){
        return new PetImpl(name, age, kind);
    }
}
