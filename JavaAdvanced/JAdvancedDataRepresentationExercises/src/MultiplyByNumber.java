import java.util.Scanner;
public class MultiplyByNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println("0");
        } else {
            bigNum = removeLeadingZerosRecursive(bigNum);
            StringBuilder sb = new StringBuilder();

            int offset = 0;
            for (int i = bigNum.length()-1; i >= 0 ; i--) {

                int currentNumber = getDigitFromNumber(bigNum, i);

                int multiplyNums = (currentNumber * number) + offset;
                int lastDigit = multiplyNums % 10;
                int deviation = multiplyNums - lastDigit;
                offset = deviation > 9 ? deviation/10 : deviation ;
                sb.insert(0, lastDigit);
            }
            if (offset !=0) {
                sb.insert(0, offset);
            }
            System.out.println(sb.toString());
        }
    }

    private static String removeLeadingZerosRecursive(String numberStr){
        int firstDigit = Character.getNumericValue(numberStr.charAt(0));
        if (firstDigit != 0) {
            return numberStr;
        } else {
            if (firstDigit == 0){
                numberStr = numberStr.substring(1);
            }
            return removeLeadingZerosRecursive( numberStr);
        }

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
