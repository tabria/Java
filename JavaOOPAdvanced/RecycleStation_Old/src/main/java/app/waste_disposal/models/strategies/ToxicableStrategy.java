package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factories.ProcessingDataFactory;

public class ToxicableStrategy extends BaseGarbageDisposalStrategy {

    private static final double ENERGY_USED_DEFAULT = 1.13;
    private static final double ENERGY_PRODUCED_DEFAULT = 2;
    private static final double CAPITAL_EARNED_DEFAULT = 0.12;
    private static final double CAPITAL_USED_DEFAULT = 0.25;


    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = super.calculateEnergyBalance(garbage, ENERGY_PRODUCED_DEFAULT, ENERGY_USED_DEFAULT);
        double capitalBalance = super.calculateCapitalBalance(garbage, CAPITAL_EARNED_DEFAULT, CAPITAL_USED_DEFAULT);

        return ProcessingDataFactory.create(energyBalance, capitalBalance);
    }
}
