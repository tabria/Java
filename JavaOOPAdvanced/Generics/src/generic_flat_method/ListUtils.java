package generic_flat_method;

import java.util.ArrayList;
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

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nulls = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i) == null){
                nulls.add(i);
            }
        }
        return nulls;
    }

    public static <T> void flatten(List<? super T> dest, List<List<? extends T>> src){
        for (List<? extends T> a:src) {
            dest.addAll(a);
        }
    }

}
