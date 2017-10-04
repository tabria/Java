import java.util.Scanner;
public class SumBigNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberOne = new StringBuilder(scanner.nextLine()).reverse().toString();
        String numberTwo = new StringBuilder(scanner.nextLine()).reverse().toString();

        numberOne = removeLeadingZeros(numberOne);
        numberTwo = removeLeadingZeros(numberTwo);

        StringBuilder sb = new StringBuilder();
        int cycles = numberOne.length() > numberTwo.length() ? numberOne.length() : numberTwo.length();

        int offset = 0;
        for (int i = 0; i <cycles ; i++) {

            int currentNumberOne = getDigitFromNumber(numberOne, i);
            int currentNumberTwo = getDigitFromNumber(numberTwo, i);

            int sum = currentNumberOne + currentNumberTwo + offset;
            int lastDigit = sum % 10;
            int deviation = sum -lastDigit;
            offset = deviation > 9 ? deviation/10 : deviation ;

            sb.append(lastDigit);
        }
        if (offset !=0) {
            sb.append(offset);
        }
        sb.reverse();
        System.out.println(sb.toString());

    }

    private static String removeLeadingZeros(String numberStr) {

        while(true) {
            int lastDigit = Character.getNumericValue(numberStr.charAt(numberStr.length()-1));
            if(lastDigit == 0) {
                numberStr = numberStr.substring(0, numberStr.length()-1);
            } else {
                break;
            }
        }

        return numberStr;
    }

    private static int getDigitFromNumber(String numberStr, int index) {
        int digit = 0;
        try {
            digit = Character.getNumericValue(numberStr.charAt(index));
        } catch (Exception e ){

        }
        return digit;
    }

}
