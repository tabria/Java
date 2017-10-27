package google;

public class Car {

    private final static String DEFAULT_VALUE = "";

    private String carModel;
    private String carSpeed;

    public Car() {
        this.carModel = DEFAULT_VALUE;
        this.carSpeed = DEFAULT_VALUE;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
