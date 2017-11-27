package collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        String addInput[] = reader.readLine().split("\\s+");
        int removeInput = Integer.parseInt(reader.readLine());

        for (String token:addInput) {
             addCollection.addIndexes(addCollection.addAtTheEnd(token));
             addRemoveCollection.addIndexes(addRemoveCollection.addAtStart(token));
             myList.addIndexes(myList.addAtStart(token));
        }




        System.out.println(addCollection.toString());
        System.out.println(addRemoveCollection.toString());
        System.out.println(myList.toString());

        for (int i = 0; i <removeInput ; i++) {
            System.out.print(addRemoveCollection.removeAtEnd());
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i <removeInput ; i++) {
            System.out.print(myList.removeAtStart());
            System.out.print(" ");
        }



    }

}
