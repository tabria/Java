package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends Command {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String unitType = super.getData()[1];
        try {
            super.getRepository().removeUnit(unitType);
        } catch (IllegalStateException ise){
            return ise.getMessage();
        }
        String output = unitType + " retired!";
        return output;
    }
}
