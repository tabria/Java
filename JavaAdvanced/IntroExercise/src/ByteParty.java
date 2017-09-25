import java.util.Scanner;
public class ByteParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i <n ; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }

        while(true) {

            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("party") && command[1].equals("over")){
                break;
            }
            int bitAction = Integer.parseInt(command[0]);
            int bitPosition = Integer.parseInt(command[1]);
            switch(bitAction){
                case -1:
                    FlipBit(bitPosition, numbers);
                    break;
                case 0:
                    UnsetBit(bitPosition, numbers);
                    break;
                case 1:
                    SetBit(bitPosition, numbers);
                    break;
                default:
                    break;
            }
        }
        PrintResult(numbers);


    }

    private static void PrintResult(int[] numbers) {
        for (int i = 0; i <numbers.length ; i++) {
            System.out.println(numbers[i]);
        }
    }

    private static void SetBit(int bitPosition, int[] numbers) {
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = numbers[i] | (1<<bitPosition);
        }
    }

    private static void UnsetBit(int bitPosition, int[] numbers) {
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = numbers[i] & ~(1<<bitPosition);
        }

    }

    private static void FlipBit(int bitPosition, int[] numbers) {
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = numbers[i] ^ (1<<bitPosition);
        }
    }
}
