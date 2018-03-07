package app.commands;

import app.core.BalanceManager;
import app.core.Engine;
import app.waste_disposal.annotations.InjectBalance;

import java.lang.reflect.Field;

public class StatusCommand extends BaseCommand {

    private static final String ENGINE_PATH = "app.core.";
    private static final String ENGINE_NAME = "Engine";

    @InjectBalance
    private BalanceManager blanceManager;

    @Override
    public String execute(String... args) throws ClassNotFoundException {

        return String.format("Energy: %.2f Capital: %.2f", this.blanceManager.getEnergyBalance(), this.blanceManager.getCapitalBalance());
    }
}
