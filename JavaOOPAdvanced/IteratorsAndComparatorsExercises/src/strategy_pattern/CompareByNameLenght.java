package strategy_pattern;

import java.util.Comparator;

public class CompareByNameLenght implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        //int compareValue = Integer.compare(first.getName().length(), second.getName().length());
        if (first.getName().length() != second.getName().length()){
            return first.getName().length() - second.getName().length();
        } else {
            //compareValue = Character.compare(first.getName().toLowerCase().charAt(0), second.getName().toLowerCase().charAt(0));
            return first.getName().toLowerCase().charAt(0) - second.getName().toLowerCase().charAt(0);
        }
    }

}
