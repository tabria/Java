package models.boats;

import Utility.Constants;
import Utility.Validator;
import contracts.IBoat;

public abstract class Boat implements IBoat {

    private String model;
    private String boatType;
    private int weight;

    Boat(String model, String boatType, int weight) {
        this.setModel(model);
        this.setWeight(weight);
        this.boatType = boatType;
    }

    public String getBoatType() {
        return boatType;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        Validator.ValidateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.ValidatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

}
