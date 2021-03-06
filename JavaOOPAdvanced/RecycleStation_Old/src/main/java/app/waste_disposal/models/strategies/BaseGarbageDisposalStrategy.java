package app.waste_disposal.models.strategies;

import app.waste_disposal.annotations.InjectManageble;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.Manageble;
import app.waste_disposal.contracts.Waste;

public abstract class BaseGarbageDisposalStrategy implements GarbageDisposalStrategy {

    @InjectManageble
    private Manageble manageble;

    protected BaseGarbageDisposalStrategy() {
        this.manageble = null;
    }

    private double calculateEnergyProduced(double garbageVolume, double energyDefault){
        return garbageVolume * energyDefault;
    }

    private double calculateEnergyUsed(double garbageVolume, double energyUsedDefault){
        return garbageVolume * energyUsedDefault;
    }

    private double calculateCapitalEarned(double garbageWeight, double capitalEarnedDefault){
        return garbageWeight * capitalEarnedDefault;
    }

    private double calculateCapitalUsed(double garbageVolume, double capitalUsedDefault){
        return garbageVolume * capitalUsedDefault;
    }

    private double calculateTotalGarbageVolume(Waste garbage){
        double garbageWeight = garbage.getWeight();
        double garbageVolume = garbage.getVolumePerKg();

        return garbageWeight * garbageVolume;
    }

    double calculateEnergyBalance(Waste garbage, double energyProducedDefault, double energyUsedDefault){

        double totalGarbageVolume = calculateTotalGarbageVolume(garbage);

        return this.calculateEnergyProduced(totalGarbageVolume, energyProducedDefault) - this.calculateEnergyUsed(totalGarbageVolume, energyUsedDefault);
    }
    double calculateCapitalBalance(Waste garbage, double capitalEarnedDefault, double capitalUsedDefault){
        double garbageWeight = garbage.getWeight();
        double totalGarbageVolume = calculateTotalGarbageVolume(garbage);

        return this.calculateCapitalEarned(garbageWeight, capitalEarnedDefault) - this.calculateCapitalUsed(totalGarbageVolume, capitalUsedDefault);
    }

}
