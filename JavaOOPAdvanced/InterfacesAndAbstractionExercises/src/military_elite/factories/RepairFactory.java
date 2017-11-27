package military_elite.factories;

import military_elite.entities.Repair;

public final class RepairFactory {

    public static Repair createRepair(String partName, int hoursWorked){
        return new Repair(partName, hoursWorked);
    }
}
