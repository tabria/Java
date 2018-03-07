package paw_inc.factories;

import paw_inc.entities.centers.AdoptionCenter;
import paw_inc.entities.centers.CastrationCenter;
import paw_inc.entities.centers.CleansingCenter;

public final class CenterFactory {


    public static CleansingCenter createCleansingCenter(String name){
        return new CleansingCenter(name);
    }

    public static AdoptionCenter createAdoptionCenter(String name){
        return new AdoptionCenter(name);
    }

    public static CastrationCenter createCastrationCenter(String name){
        return new CastrationCenter(name);
    }
}
