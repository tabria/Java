package overload;

public class MathOperation {

    protected int add(int valueA, int valueB){
        return valueA + valueB;
    }

    protected int add(int valueA, int valueB, int valueC){
        return valueA + valueB + valueC;
    }

    protected int add(int valueA, int valueB, int valueC, int valueD){
        return this.add(valueA, valueB, valueC) +  valueD;
    }

}
