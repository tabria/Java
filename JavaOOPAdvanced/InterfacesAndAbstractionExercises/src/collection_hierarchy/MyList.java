package collection_hierarchy;

import java.util.LinkedList;
import java.util.List;

public class MyList implements Addable, Removable {


    private List<String> myList;
    private List<Integer> addIndexes;

    public MyList() {
        this.myList = new LinkedList<>();
        this.addIndexes = new LinkedList<>();
    }

    void addIndexes(int index){
        this.addIndexes.add(index);
    }

    @Override
    public int addAtStart(String element) {
        this.myList.add(0, element);
        return 0;
    }

    @Override
    public String removeAtStart() {
        String element = this.myList.get(0);
        this.myList.remove(0);
        return element;
    }

    @Override
    public String toString() {

        return this.addIndexes.toString().replace("[", "").replace("]","").replace(",", "") ;
    }
}
