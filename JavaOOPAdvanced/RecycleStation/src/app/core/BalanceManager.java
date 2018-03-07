package app.core;

import app.waste_disposal.contracts.ProcessingData;

public interface BalanceManager {
    double getEnergyBalance();

    double getCapitalBalance();

    void processData(ProcessingData data);
}
