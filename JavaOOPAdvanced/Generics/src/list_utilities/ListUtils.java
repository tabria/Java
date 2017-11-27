package list_utilities;

import java.util.List;

public class ListUtils<T> {

    public static <T extends Comparable> T getMin(List<T> list){
        if (list.size()<1){
            throw new IllegalArgumentException();
        }

        T min = list.get(0);
        for (int i = 1; i <list.size() ; i++) {
            if (min.compareTo(list.get(i)) > 0){
                min = list.get(i);
            }
        }

        return min;
    }

    public static <T extends Comparable> T getMax(List<T> list){
        T max = list.get(0);
        for (int i = 1; i <list.size() ; i++) {
            if (max.compareTo(list.get(i)) <0 ){
                max = list.get(i);
            }
        }
        return max;
    }

}
