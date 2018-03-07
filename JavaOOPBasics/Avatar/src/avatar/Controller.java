package avatar;

import avatar.entities.benders.Bender;
import avatar.entities.monuments.Monument;
import avatar.factories.BenderFactory;
import avatar.factories.MonumentFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {


    private static Nation airNation = new Nation();
    private static Nation fireNation = new Nation();
    private static Nation waterNation = new Nation();
    private static Nation earthNation = new Nation();




    static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder war = new StringBuilder();
        int counter = 1;


        while(true){
            String[] rowInfo = reader.readLine().split("\\s+");
            if ("Quit".equals(rowInfo[0])){
                break;
            }
            switch(rowInfo[0]){
                case "Bender":
                    getNation(rowInfo[1]).addBender(BenderFactory.create(rowInfo));
                    break;
                case "Monument":
                    getNation(rowInfo[1]).addMonument(MonumentFactory.create(rowInfo));
                    break;
                case "Status":
                    addBenderStatus(rowInfo[1], sb);
                    addMonumentStatus(rowInfo[1], sb);
                    break;
                case "War":
                    war.append(String.format("War %d issued by %s%n", counter++, rowInfo[1]));
                    calculateWarResults();
                    break;
                    default:
                        break;
            }

        }
        System.out.print(sb);
        System.out.println(war);


    }

    private static void calculateWarResults() {
        double airPower =getNationPower(airNation);
        double firePower = getNationPower(fireNation);
        double earthPower = getNationPower(earthNation);
        double waterPower = getNationPower(waterNation);

        if (airPower > firePower && airPower>earthPower && airPower>waterPower){
            fireNation.clearNation();
            earthNation.clearNation();
            waterNation.clearNation();
        } else if (firePower > airPower && firePower > earthPower && firePower>waterPower){
            airNation.clearNation();
            earthNation.clearNation();
            waterNation.clearNation();
        } else if (earthPower > airPower && earthPower > firePower && earthPower > waterPower){
            airNation.clearNation();
            fireNation.clearNation();
            waterNation.clearNation();
        } else {
            airNation.clearNation();
            fireNation.clearNation();
            earthNation.clearNation();
        }

    }

    private static double getNationPower(Nation currentNation) {
        double totalBendersPower = 0;
        for (Bender bender:currentNation.getBenders()) {
            totalBendersPower += (bender.totalPower());
        }
        long monumentPower = 0L;
        for (Monument monument:currentNation.getMonuments()) {
            monumentPower += monument.monumentPower();
        }

        totalBendersPower += (totalBendersPower/100) * monumentPower;
        return totalBendersPower;
    }


    private static void addMonumentStatus(String nationType, StringBuilder sb) {
        if (getNation(nationType).getMonuments().size() > 0){
            sb.append("Monuments:").append(System.lineSeparator());
            for (Monument monument: getNation(nationType).getMonuments()) {
                sb.append(monument).append(System.lineSeparator());
            }
        } else {
            sb.append("Monuments: None").append(System.lineSeparator());
        }
    }

    private static void addBenderStatus(String nationType, StringBuilder sb) {
        sb.append(String.format("%s Nation%n", nationType));
        if (getNation(nationType).getBenders().size() > 0){
            sb.append("Benders:").append(System.lineSeparator());
            for (Bender bender: getNation(nationType).getBenders()) {
                sb.append(bender).append(System.lineSeparator());
            }
        } else {
            sb.append("Benders: None").append(System.lineSeparator());
        }
    }

    private static Nation getNation (String nationType){
        switch(nationType){
            case "Air":
                return airNation;
            case "Fire":
                return fireNation;
            case "Water":
                return waterNation;
            case "Earth":
                return earthNation;
                default:
                    return null;
        }
    }

}
