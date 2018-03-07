package avatar.factories;

import avatar.entities.benders.*;

public final class BenderFactory {
    public static Bender create(String[] benderInfo){
        switch(benderInfo[1]){
            case "Air":
                return new AirBender(benderInfo[2], Integer.parseInt(benderInfo[3]), Double.parseDouble(benderInfo[4]));
            case "Fire":
                return new FireBender(benderInfo[2], Integer.parseInt(benderInfo[3]), Double.parseDouble(benderInfo[4]));
            case "Water":
                return new WaterBender(benderInfo[2], Integer.parseInt(benderInfo[3]), Double.parseDouble(benderInfo[4]));
            case "Earth":
                return new EarthBender(benderInfo[2], Integer.parseInt(benderInfo[3]), Double.parseDouble(benderInfo[4]));
                default:
                    return null;
        }
    }
}
