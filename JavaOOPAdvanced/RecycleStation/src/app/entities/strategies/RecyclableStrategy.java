package app.entities.strategies;

import app.factories.ProcessingDataFactory;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;

public class RecyclableStrategy extends BaseStrategy {

    private static final double ENERGY_USED_DEFAULT = 0.5;
    private static final double ENERGY_PRODUCED_DEFAULT = 0;
    private static final double CAPITAL_EARNED_DEFAULT = 400;
    private static final double CAPITAL_USED_DEFAULT = 0;


    @Override
    public ProcessingData processGarbage(Waste garbage) {

        double energyBalance = super.calculateEnergyBalance(garbage, ENERGY_PRODUCED_DEFAULT, ENERGY_USED_DEFAULT);
        double capitalBalance = super.calculateCapitalBalance(garbage, CAPITAL_EARNED_DEFAULT, CAPITAL_USED_DEFAULT);

        return ProcessingDataFactory.create(energyBalance, capitalBalance);
    }

}
