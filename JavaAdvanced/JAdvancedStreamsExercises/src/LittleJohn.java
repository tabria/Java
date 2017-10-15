import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bigArrowsQuantity = 0;
        long mediumArrowsQuantity =0;
        long smallArrowsQuantity = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <5 ; i++) {
            sb.append(scanner.nextLine());
            bigArrowsQuantity += countArrows(sb, "big");
            mediumArrowsQuantity += countArrows(sb, "medium");
            smallArrowsQuantity += countArrows(sb, "small");
            sb.setLength(0);
        }

        sb.setLength(0);
        sb.append(smallArrowsQuantity)
                .append(mediumArrowsQuantity)
                .append(bigArrowsQuantity);


        String binaryNumber  = Integer.toBinaryString(Integer.valueOf(sb.toString()));
        sb.setLength(0);
        sb.append(binaryNumber).reverse().insert(0, binaryNumber);

        System.out.println(Long.parseLong(sb.toString(), 2));
    }

    private static long countArrows(StringBuilder sb, String type) {
        String inputText = sb.toString();
        String arrowPattern = getArrowTypePattern(type);
        Pattern bigArrows = Pattern.compile(arrowPattern);
        Matcher matcher = bigArrows.matcher(inputText);
        int countArrows = 0;
        while (matcher.find()){
            countArrows++;
        }
        if (countArrows > 0) {
            String text = sb.toString().replaceAll(arrowPattern, "x");
            sb.setLength(0);
            sb.append(text);
        }
        return countArrows;
    }

    private static String getArrowTypePattern(String type) {
        String[] arrowTypes = new String[] {"[>]{3}[-]{5}[>]{2}", "[>]{2}[-]{5}[>]{1}", "[>]{1}[-]{5}[>]{1}" };
        String arrow = "";
        switch(type){
            case "big":
                arrow = arrowTypes[0];
                break;
            case "medium":
                arrow = arrowTypes[1];
                break;
            case "small":
                arrow = arrowTypes[2];
                break;
        }
        return arrow;
    }

}
