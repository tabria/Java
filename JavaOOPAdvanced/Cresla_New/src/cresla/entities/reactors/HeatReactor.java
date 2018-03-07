package cresla.entities.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends BaseReactor {

    private int heatReductionIndex;

    public HeatReactor(int id, Container moduleContainer, int heatReduction) {
        super(id, moduleContainer);
        this.heatReductionIndex = heatReduction;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + this.heatReductionIndex;
    }
}
