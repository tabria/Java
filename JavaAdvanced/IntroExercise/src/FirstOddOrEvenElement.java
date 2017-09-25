import java.util.Scanner;
public class FirstOddOrEvenElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] numbersStr = scanner.nextLine().split(" ");
        String[] typeInfo = scanner.nextLine().split(" ");

        String output = "";
        int outputElements = Integer.parseInt(typeInfo[1]);
        String numberType = typeInfo[2];

        for (int i = 0; i <numbersStr.length ; i++) {

            if (outputElements < 1) {
                break;
            }

            int currentNumber = Integer.parseInt(numbersStr[i]);
            String spacer = output.length() > 0 ? " " : "";
            if (numberType.equals("even") && currentNumber % 2 == 0){
                output += spacer + currentNumber;
                outputElements--;
            } else if (numberType.equals("odd") && currentNumber % 2 != 0) {
                output += spacer + currentNumber;
                outputElements--;
            }
        }

        System.out.println(output);

    }

}
