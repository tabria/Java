package app.core;

import app.waste_disposal.contracts.ProcessingData;

public class BalanceManagerImpl implements BalanceManager {

    private static final double ENERGY_BALANCE_DEFAULT = 0.0;
    private static final double CAPITAL_BALANCE_DEFAULT = 0.0;

    private double energyBalance;
    private double capitalBalance;

    public BalanceManagerImpl() {
        this.energyBalance = ENERGY_BALANCE_DEFAULT;
        this.capitalBalance = CAPITAL_BALANCE_DEFAULT;
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    @Override
    public void processData(ProcessingData data){
        this.energyBalance += data.getEnergyBalance();
        this.capitalBalance += data.getCapitalBalance();
    }
}
