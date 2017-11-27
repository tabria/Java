package pet_clinics.iterators;

import pet_clinics.interfaces.Pet;

import java.util.*;

public final class ReleaseIndexIterator implements Iterator<Integer> {

    private int index;
    private List<Pet> rooms;
    private List<Integer> releaseIndexes;

    public ReleaseIndexIterator(Pet[] roomsCount) {
        this.index = 0;
        this.setRooms(roomsCount);
        this.setReleaseIndexes();
    }

    private void setReleaseIndexes() {
        List<Integer> releaseOrder = new LinkedList<>();
        releaseOrder.add((this.rooms.size() - 1) / 2 );
        for (int i = 0; i <(this.rooms.size() - 1) / 2; i++) {
            releaseOrder.add(1, this.rooms.size() -1 - i);
            releaseOrder.add(i);
        }
        this.releaseIndexes = releaseOrder;
    }

    private void setRooms(Pet[] roomsCount) {
        this.rooms = Arrays.asList(roomsCount);
    }

    @Override
    public boolean hasNext() {
        return this.index < this.releaseIndexes.size();
    }

    @Override
    public Integer next() {
        return this.releaseIndexes.get(this.index++);
    }
}
