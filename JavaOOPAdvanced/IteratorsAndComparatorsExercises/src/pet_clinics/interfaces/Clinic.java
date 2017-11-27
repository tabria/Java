package pet_clinics.interfaces;

public interface Clinic<T extends Pet> extends Iterable<Pet>{


    boolean addPet(Pet pet);

    boolean releasePet();

    boolean HasEmptyRooms();

    String getAllRoomsInfo();

    Pet getRoom(int roomNumber);
}
