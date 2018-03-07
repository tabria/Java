package app.waste_disposal.models.wastes;

import app.waste_disposal.contracts.Waste;

public abstract class BaseWaste implements Waste {

    private String name;
    private double weight;
    private double volumePerKg;

    protected BaseWaste(String name, double weight, double volumePerKg) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }
}
