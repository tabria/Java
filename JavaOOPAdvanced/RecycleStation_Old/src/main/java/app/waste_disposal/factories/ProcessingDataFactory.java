package app.waste_disposal.factories;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.models.ProcessingDataImpl;

public final class ProcessingDataFactory {

    public static ProcessingData create(){
        return new ProcessingDataImpl();
    }

    public static ProcessingData create(double energyBalance, double capitalBalance){
        return new ProcessingDataImpl(energyBalance, capitalBalance);
    }
}
