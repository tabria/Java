package app.waste_disposal.models;

import app.waste_disposal.contracts.Manageble;
import app.waste_disposal.contracts.Waste;

public class ManagebleImpl implements Manageble {

    private double energyLimit;
    private double capitalLimit;
    private String wasteType;

    public ManagebleImpl() {
    }

    public ManagebleImpl(double energyLimit, double capitalLimit, String wasteType) {
        this.energyLimit = energyLimit;
        this.capitalLimit = capitalLimit;
        this.wasteType = wasteType;
    }

    public double getEnergyLimit() {
        return this.energyLimit;
    }

    public double getCapitalLimit() {
        return this.capitalLimit;
    }

    public String getWasteType() {
        return this.wasteType;
    }
}
