package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.annotations.InjectEngine;
import app.waste_disposal.contracts.Manageble;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.engines.Engine;
import app.waste_disposal.factories.WasteFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ProcessGarbageCommand extends BaseCommand {

    private static final String ENGINE_PATH ="app.waste_disposal.engines.";
    private static final String ENGINE_NAME ="Engine";

    @Inject
    private String[] garbageInfo;
    @InjectEngine
    private Engine engine;

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        String name = this.garbageInfo[0];
        double weight = Double.parseDouble(this.garbageInfo[1]);
        double volume = Double.parseDouble(this.garbageInfo[2]);
        String type = this.garbageInfo[3];
        ProcessingData processedData = this.engine.getGarbageProcessor().processWaste(WasteFactory.create(name, weight, volume, type));
        if (this.isManageble(type)){

            Field energyField = Class.forName(ENGINE_PATH + ENGINE_NAME ).getDeclaredField("energy");
            Field capitalField = Class.forName(ENGINE_PATH + ENGINE_NAME).getDeclaredField("capital");

            energyField.setAccessible(true);
            capitalField.setAccessible(true);

            double currentEnergyBalance = this.engine.getEnergy() + processedData.getEnergyBalance();
            double currentCapitalBalance =  this.engine.getCapital() + processedData.getCapitalBalance();

            energyField.set(this.engine, currentEnergyBalance);
            capitalField.set(this.engine,currentCapitalBalance);

            return String.format("%.2f kg of %s successfully processed!", weight, name);
        } else {

            return "Processing Denied!";
        }
    }

    private boolean isManageble(String type){
        Manageble currentManagableLimit = this.engine.getManageble();

        if ( currentManagableLimit== null){
            return true;
        } else if(!currentManagableLimit.getWasteType().equals(type)){
            return true;
        } else if ((currentManagableLimit.getEnergyLimit() <= this.engine.getEnergy()) && currentManagableLimit.getCapitalLimit() <= this.engine.getCapital()
                ){
            return true;
        }
        return false;
    }
}
