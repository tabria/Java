package models.boats;

import Utility.Validator;
import contracts.IRace;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, String boatType, int weight, int oars) {
        super(model, boatType, weight);
        this.setOars(oars);
    }

    private void setOars(int oars) {
        Validator.ValidatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double CalculateRaceSpeed(IRace race) {
        return (this.oars * 100) - super.getWeight() + race.getOceanCurrentSpeed();
    }
}
