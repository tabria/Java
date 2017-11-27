package collection_hierarchy;

import java.util.LinkedList;
import java.util.List;

public class AddRemoveCollection implements Addable, EndRemovable {

    private List<String> addRemoveCollection;
    private List<Integer> addIndexes;

    public AddRemoveCollection() {
        this.addRemoveCollection = new LinkedList<>();
        this.addIndexes = new LinkedList<>();
    }

    void addIndexes(int index){
        this.addIndexes.add(index);
    }

    void remove(int cycles){

    }

    @Override
    public int addAtStart(String element) {
        this.addRemoveCollection.add(0, element);
        return 0;
    }

    @Override
    public String removeAtEnd() {
        String element = this.addRemoveCollection.get(this.addRemoveCollection.size()-1);
        this.addRemoveCollection.remove(this.addRemoveCollection.size()-1);
        return element;
    }

    @Override
    public String toString() {

        return this.addIndexes.toString().replace("[", "").replace("]","").replace(",", "") ;
    }

}
