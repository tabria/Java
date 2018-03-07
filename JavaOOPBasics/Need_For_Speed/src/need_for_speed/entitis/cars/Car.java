package need_for_speed.entitis.cars;

import need_for_speed.utilities.Constants;

public abstract class Car {

    private String brand;
    private String model;

    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

     protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.setBrand(brand);
        this.setModel(model);
        this.setYearOfProduction(yearOfProduction);
        this.setHorsepower(horsepower);
        this.setAcceleration(acceleration);
        this.setSuspension(suspension);
        this.setDurability(durability);
    }


    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private int getYearOfProduction() {
        return this.yearOfProduction;
    }

    private void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    private void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }


    public void tuneCar (int tuneIndex, String addOns){
            this.horsepower += tuneIndex;
            this.suspension += (tuneIndex * Constants.TUNE_INDEX_MODIFIER )/ Constants.PERCENTAGE;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s %s %d\r\n", this.getBrand(), this.getModel(), this.getYearOfProduction()))
                .append(String.format("%d HP, 100 m/h in %d s\r\n",this.getHorsepower(), this.getAcceleration()))
                .append(String.format("%d Suspension force, %d Durability\r\n",this.getSuspension(), this.getDurability()));
        return sb.toString() ;
    }

}
