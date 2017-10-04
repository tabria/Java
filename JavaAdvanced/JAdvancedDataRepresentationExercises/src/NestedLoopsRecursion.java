import java.util.Scanner;
public class NestedLoopsRecursion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        int[] loops = new int[cycles];

        nestedLoops(loops, cycles, 0);

    }

    private static void nestedLoops(int[] loops, int cycles, int level) {
        if (cycles == level){
            printLoops(loops);
            return;
        } else {
            for (int i = 1; i <=cycles ; i++) {
                loops[level] = i;
                nestedLoops(loops, cycles, level +1);
            }
        }
    }

    private static void printLoops(int[] loops) {
        for (int i = 0; i <loops.length ; i++) {
            System.out.print(loops[i] + " ");
        }
        System.out.println();
    }
}
