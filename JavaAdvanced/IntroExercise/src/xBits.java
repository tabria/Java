import java.util.Scanner;
public class xBits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[8];
        int maxNumber = Integer.MIN_VALUE;
        for (int i = 0; i <numbers.length ; i++) {
            numbers[i] = Integer.parseInt(scanner.nextLine());
            if (numbers[i]>maxNumber) {
                maxNumber = numbers[i];
            }
        }
        int maxIndex = 32-Integer.numberOfLeadingZeros(maxNumber);
        int countX = xCounter(numbers, maxIndex);

        System.out.println(countX);
    }

    private static int xCounter(int[] numbers, int maxIndex) {
        int startIndex = 0;
        int countXes = 0;
        String fullX = "";

        for (int i = 0; i <numbers.length ; i++) {

            int currentNumber = numbers[i];
            int firstBit = (currentNumber>>startIndex) & 1;
            int secondBit = (currentNumber>>(startIndex+1)) & 1;
            int thirdBit = (currentNumber>>(startIndex+2)) & 1;

            if (firstBit ==1 && secondBit == 0 && thirdBit == 1) {
                fullX += "101";
            } else if (firstBit ==0 && secondBit == 1 && thirdBit == 0 && fullX.equals("101")) {
                fullX = fullX + "010";
            } else {
                fullX ="";
            }

            if (fullX.equals("101010101")) {
                countXes++;
                fullX ="";
            }
            if (i==numbers.length-1 && startIndex < maxIndex-2) {
                i=-1;
                startIndex += 1;
                fullX ="";
            }

        }
        return countXes;
    }
}
