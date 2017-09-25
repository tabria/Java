import java.util.Scanner;
public class Xbit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] binaryNumbers = new String[8];
        for (int i = 0; i <binaryNumbers.length ; i++) {
           String binary = String.format("%32s", Integer.toBinaryString(Integer.parseInt(scanner.nextLine()))).replace(" ", "0");
           binaryNumbers[i] = binary;
        }

        int counter =0;
        for (int k=0; k<binaryNumbers.length-2; k++){
            for (int j=0; j<binaryNumbers[k].length()-2; j++){
                String a = binaryNumbers[k].charAt(j) + "" + binaryNumbers[k].charAt(j+1) + "" + binaryNumbers[k].charAt(j+2);
                String b = binaryNumbers[k+1].charAt(j) + "" + binaryNumbers[k+1].charAt(j+1) + "" + binaryNumbers[k+1].charAt(j+2);
                String c = binaryNumbers[k+2].charAt(j) + "" + binaryNumbers[k+2].charAt(j+1) + "" + binaryNumbers[k+2].charAt(j+2);
                if (a.equals("101") && b.equals("010") && c.equals("101")){
                    counter++;
                }
            }
        }

        System.out.println(counter);

    }

}
