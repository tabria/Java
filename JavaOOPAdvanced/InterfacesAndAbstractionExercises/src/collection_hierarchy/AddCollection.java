package collection_hierarchy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddCollection implements EndAddable {

    private List<String> addCollection;
    private List<Integer> addedIndexes;

    public AddCollection() {
        this.addCollection = new LinkedList<String>();
        this.addedIndexes = new LinkedList<>();
    }


    public void addIndexes(int index){
        this.addedIndexes.add(index);
    }

    @Override
    public int addAtTheEnd(String element) {
        int index = this.addCollection.size();
        this.addCollection.add(element);
        return index;
    }

    @Override
    public String toString() {

        return this.addedIndexes.toString().replace("[", "").replace("]","").replace(",", "") ;
    }
}
