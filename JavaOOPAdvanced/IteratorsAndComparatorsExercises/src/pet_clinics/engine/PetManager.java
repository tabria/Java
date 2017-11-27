package pet_clinics.engine;

import pet_clinics.factories.ClinicFactory;
import pet_clinics.interfaces.Clinic;
import pet_clinics.interfaces.Pet;
import pet_clinics.factories.PetFactory;

import java.util.HashMap;



public class PetManager{

    private HashMap<String, Clinic> clinic;
    private HashMap<String, Pet> pets;

    public PetManager() {
        this.clinic = new HashMap<>();
        this.pets = new HashMap<>();
    }

    void createClinic(String name, int rooms){
        if (rooms % 2 == 0 || this.clinic.containsKey(name)){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.clinic.putIfAbsent(name, ClinicFactory.createClinic(name, rooms));
    }

    void createPet(String name, int age, String kind){
        this.pets.putIfAbsent(name, PetFactory.createPet(name, age, kind));
    }

    boolean addPet(String petName, String clinicName){
        if (!this.pets.containsKey(petName) || !this.clinic.containsKey(clinicName)){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        return this.clinic.get(clinicName).addPet(this.pets.get(petName));
    }

    boolean releasePet(String clinicName){
        if (!this.clinic.containsKey(clinicName)){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        return this.clinic.get(clinicName).releasePet();
    }

    boolean HasEmptyRooms(String clinicName){
        if (!this.clinic.containsKey(clinicName)){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        return this.clinic.get(clinicName).HasEmptyRooms();
    }

    String printAllRooms(String clinicName) {
        if (this.clinic.containsKey(clinicName)){
            return this.clinic.get(clinicName).getAllRoomsInfo();
        }
        throw new IllegalArgumentException("Invalid Operation!");
    }

    String printRoom(String clinicName, int roomNumber) {
        if (this.clinic.containsKey(clinicName)){
            Pet pet = this.clinic.get(clinicName).getRoom(roomNumber);
            if (pet == null){
                return "Room empty";
            } else {
                return pet.toString();
            }
        }
        throw new IllegalArgumentException("Invalid Operation!");
    }
}
