import java.util.Scanner;
public class VehiclePark {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] availableVehicles = scanner.nextLine().split(" ");

        while(true){
            String[] order = scanner.nextLine().toLowerCase().split(" ");
            if (order[0].equals("end") && order[2].equals("customers!")){
                break;
            }
            String orderVehicle = order[0].charAt(0) + order[2];
            int soldCar = 0;
            for (int i = 0; i < availableVehicles.length; i++) {
                String currentVehicle = availableVehicles[i];
                if (currentVehicle.equals(orderVehicle)) {
                    int seats = Integer.parseInt(currentVehicle.substring(1));
                    int price = currentVehicle.charAt(0) * seats;
                    availableVehicles[i] = "sold";
                    soldCar++;
                    System.out.println("Yes, sold for " + price + "$");
                    break;
                }
            }
            if (soldCar<1) {
                System.out.println("No");
            }
        }

        String available = "";
        int sold = 0;

        for (int i = 0; i <availableVehicles.length ; i++) {
            String currentVehicle = availableVehicles[i];
            String spacer = available.isEmpty() ? "" : ", ";
            if (currentVehicle.equals("sold")){
                sold++;
            } else {
                available += spacer + currentVehicle;
            }
        }

        System.out.println("Vehicles left: " + available);
        System.out.println("Vehicles sold: " + sold);

    }
}
