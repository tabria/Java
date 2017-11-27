package froggy;

import java.util.*;
import java.util.function.Consumer;

public class Lake<T extends Integer> implements Froggy<T>, Iterable<T> {

    private List<T> lakeNumbers;

    public Lake(T... numbers) {
        this.lakeNumbers = Arrays.asList(numbers);
    }

    @Override
    public List<T> getLakeNumbers() {
        return Collections.unmodifiableList(this.lakeNumbers);
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }



    private final class Frog implements Iterator<T>{
        int index;
        private List<T> nums;

        public Frog() {
            this.index = 0;
            this.resultNums();
        }

        void resultNums(){
            this.nums = new ArrayList<>();
            for (int i = 0; i < lakeNumbers.size() ; i++) {
                if (i % 2 == 0){
                    this.nums.add(lakeNumbers.get(i));
                }
            }

            for (int i = 0; i <lakeNumbers.size() ; i++) {
                if (i % 2 != 0){
                   this.nums.add(lakeNumbers.get(i));
                }
            }
        }

        @Override
        public boolean hasNext() {
            return this.index < this.nums.size();
        }

        @Override
        public T next() {
            return this.nums.get(this.index++);
        }
    }
}
