package cresla.entities.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;

    public CryoReactor(int id, Container moduleContainer, int cryoProduction) {
        super(id, moduleContainer);
        this.cryoProductionIndex = cryoProduction;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * this.cryoProductionIndex;
    }

}
