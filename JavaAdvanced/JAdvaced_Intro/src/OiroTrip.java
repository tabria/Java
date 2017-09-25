import java.math.BigDecimal;
import java.util.Scanner;

public class OiroTrip {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double quantity = Double.parseDouble(scanner.nextLine());
        double pricePerKg = 1.20;

        BigDecimal priceInDM = new BigDecimal(quantity * pricePerKg)
                .multiply(new BigDecimal("4210500000000"));

        System.out.printf("%.2f marks", priceInDM);



    }
}
