package app.factories;

import app.entities.ProcessingDataImpl;
import app.waste_disposal.contracts.ProcessingData;

public final class ProcessingDataFactory {

    public static ProcessingData create(){
        return new ProcessingDataImpl();
    }

    public static ProcessingData create(double energyBalance, double capitalBalance){
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }

}
