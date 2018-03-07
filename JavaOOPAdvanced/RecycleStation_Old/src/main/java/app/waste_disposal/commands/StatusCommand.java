package app.waste_disposal.commands;

import app.waste_disposal.annotations.InjectEngine;
import app.waste_disposal.engines.Engine;

import java.lang.reflect.Field;

public class StatusCommand extends BaseCommand {

    @InjectEngine
    private Engine engine;

    @Override
    public String execute() throws NoSuchFieldException, IllegalAccessException {

        return String.format("Energy: %.2f Capital: %.2f", this.engine.getEnergy(), this.engine.getCapital());
    }
}
