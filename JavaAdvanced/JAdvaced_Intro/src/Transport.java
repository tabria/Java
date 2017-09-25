import java.util.Scanner;
public class Transport {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       double distanceToTravel = Double.parseDouble(scanner.nextLine());
       String dayTime = scanner.nextLine();

        double tripPrice =0.0;

        double taxiInitial = 0.70;
        double taxiDayTime = 0.79;
        double taxiNightTime = 0.90;
        double bus = 0.09;
        double train = 0.06;

        if (distanceToTravel < 20) {
            switch(dayTime){
                case "night":
                    tripPrice = taxiInitial+taxiNightTime*distanceToTravel;
                    break;
                default:
                    tripPrice = taxiInitial+taxiDayTime*distanceToTravel;
                    break;
            }
        } else if (distanceToTravel <100) {
            tripPrice = bus*distanceToTravel;
        } else {
            tripPrice = train*distanceToTravel;
        }

        System.out.printf("%.2f", tripPrice);
    }

}
