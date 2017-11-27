package generic_scale;

public class Scale<T extends Comparable>  {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier(){
        int result = this.left.compareTo(this.right);
        if (result < 0){
            return this.right;
        }
        if (result > 0){
            return this.left;
        }

        return null;
    }
}
