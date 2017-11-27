package pet_clinics.iterators;

import pet_clinics.interfaces.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class AccommodationIndexIterator implements Iterator<Integer> {

    private int index = 0;
    private List<Pet> roomsInClinic;
    private List<Integer> accommodationIndexes;

    public AccommodationIndexIterator(Pet[] rooms) {
        this.index = 0;
        this.setRoomsInClinic(rooms);
        this.setAccommodationIndexes();
    }

    private void setRoomsInClinic(Pet[] roomsInClinic) {
        this.roomsInClinic = Arrays.asList(roomsInClinic);
    }

    private void setAccommodationIndexes(){
        List<Integer> roomOrder = new ArrayList<>();
        int startIndex = (this.roomsInClinic.size() - 1)/2;
        roomOrder.add(startIndex);
        for (int i = 0; i <(this.roomsInClinic.size() - 1)/2; i++) {
            roomOrder.add(startIndex - 1 - i);
            roomOrder.add(startIndex + 1 + i);
        }
        this.accommodationIndexes = roomOrder;
    }

    @Override
    public boolean hasNext() {
        return this.index < accommodationIndexes.size();
    }

    @Override
    public Integer next() {
        return accommodationIndexes.get(this.index++);
    }


}
