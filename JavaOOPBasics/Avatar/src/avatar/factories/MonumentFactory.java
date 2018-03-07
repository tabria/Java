package avatar.factories;

import avatar.entities.monuments.*;

public class MonumentFactory {
    
    
    public static Monument create(String[] monumentInfo){
        switch(monumentInfo[1]){
            case "Air":
                return new AirMonument(monumentInfo[2], Integer.parseInt(monumentInfo[3]));
            case "Fire":
                return new FireMonument(monumentInfo[2], Integer.parseInt(monumentInfo[3]));
            case "Water":
                return new WaterMonument(monumentInfo[2], Integer.parseInt(monumentInfo[3]));
            case "Earth":
                return new EarthMonument(monumentInfo[2], Integer.parseInt(monumentInfo[3]));
            default:
                return null;
        }
    }
    
}
