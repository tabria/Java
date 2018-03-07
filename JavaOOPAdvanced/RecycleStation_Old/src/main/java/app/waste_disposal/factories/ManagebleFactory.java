package app.waste_disposal.factories;

import app.waste_disposal.contracts.Manageble;
import app.waste_disposal.models.ManagebleImpl;

public final class ManagebleFactory {

    public static Manageble createEmpty(){
        return  new ManagebleImpl();
    }

    public static Manageble create(double energy, double capital, String name){

        return new ManagebleImpl(energy, capital, name);
    }

}
