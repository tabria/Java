import java.lang.reflect.Array;
import java.util.*;

public class CustomComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> nums = new ArrayList<>();
        for (int num : numbers) {
            nums.add(num);
        }


        Comparator<Integer> compareOdd = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1%2 != 0) {
                    return 1;
                }
                return -1;
            }

        };
        Comparator<Integer> compareEven = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1%2 != 0 && o2%2 != 0){
                    if (o1<o2){
                        return -1;
                    }
                    return 1;
                }
                if (o1%2 == 0 && o2%2 == 0){
                    if (o1<o2){
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }
        };

        Collections.sort(nums, compareOdd);
        Collections.sort(nums, compareEven);

        for (Integer value : nums) {
            System.out.print(value + " ");
        }
    }
}

