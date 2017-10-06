import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new HashSet<>();
        int size = parking.size();

        while(true){
            String line = scanner.nextLine();
            if (line.equals("END")){
                break;
            }
            String[] car = line.split(", ");
            if (car[0].equals("IN")){
                parking.add(car[1]);
            } else if (car[0].equals("OUT")){
                parking.remove(car[1]);
            }
        }
        // or parking.size() < 1
        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parking) {
                System.out.println(s);
            }
        }

    }

}
