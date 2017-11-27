package pet_clinics.entities;

import pet_clinics.interfaces.Clinic;
import pet_clinics.interfaces.Pet;
import pet_clinics.iterators.AccommodationIndexIterator;
import pet_clinics.iterators.ReleaseIndexIterator;
import java.util.Arrays;
import java.util.Iterator;


public class ClinicImpl<T extends Pet> implements Clinic<Pet>, Iterable<Pet> {

    private String name;
    private Pet[] rooms;
    private Iterator<Integer> roomAccommodationIndex;
    private Iterator<Integer> roomReleaseIndex;

    public ClinicImpl(String name, int roomsCount) {
        this.name = name;
        this.rooms = new Pet[roomsCount];
        this.setRoomAccommodationIndex();
        this.setRoomReleaseIndex();
    }

    private void setRoomAccommodationIndex() {
        this.roomAccommodationIndex = new AccommodationIndexIterator(this.rooms);
    }

    private void setRoomReleaseIndex(){
        this.roomReleaseIndex = new ReleaseIndexIterator(this.rooms);
    }

    @Override
    public boolean addPet(Pet pet){
       while(this.roomAccommodationIndex.hasNext()){
           Integer roomIndex = this.roomAccommodationIndex.next();
           if (this.rooms[roomIndex] == null){
               this.rooms[roomIndex] = pet;
               return true;
           }
       }
       return false;
    }

    @Override
    public boolean releasePet(){
        while(this.roomReleaseIndex.hasNext()){
            Integer roomIndex = this.roomReleaseIndex.next();
            if (this.rooms[roomIndex] != null){
                this.rooms[roomIndex] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean HasEmptyRooms(){
        return Arrays.asList(this.rooms).contains(null);
    }

    @Override
    public String getAllRoomsInfo(){
        StringBuilder sb = new StringBuilder();
        Iterator<Pet> petItr = this.iterator();
        for (; petItr.hasNext(); ) {
            Pet pet = petItr.next();
            if (pet == null){
                sb.append("Room empty\r\n");
            } else {
                sb.append(pet).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public Pet getRoom(int roomNumber) {
        return this.rooms[roomNumber - 1];
    }

    @Override
    public Iterator<Pet> iterator() {
        return new PetIterator();
    }


    private final class PetIterator implements Iterator<Pet>{
        int index;

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[this.index++];
        }
    }
}
