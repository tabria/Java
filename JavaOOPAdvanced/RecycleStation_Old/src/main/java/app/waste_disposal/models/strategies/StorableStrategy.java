package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.ProcessingDataFactory;

public class StorableStrategy extends BaseGarbageDisposalStrategy {

    private static final double ENERGY_USED_DEFAULT = 0.13;
    private static final double ENERGY_PRODUCED_DEFAULT = 0;
    private static final double CAPITAL_EARNED_DEFAULT = 0;
    private static final double CAPITAL_USED_DEFAULT = 0.65;


    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = super.calculateEnergyBalance(garbage, ENERGY_PRODUCED_DEFAULT, ENERGY_USED_DEFAULT);
        double capitalBalance = super.calculateCapitalBalance(garbage, CAPITAL_EARNED_DEFAULT, CAPITAL_USED_DEFAULT);

        return ProcessingDataFactory.create(energyBalance, capitalBalance);
    }
}
