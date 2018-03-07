package nfs.entities.cars;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;


     protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.setDurability(durability);
    }


    public int getSuspension() {
        return this.suspension;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getDurability() {
        return this.durability;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void tuneCar(int tuneIndex, String addOn){
            this.horsepower += tuneIndex;
            this.suspension += tuneIndex/2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(String.format("%s %s %d%n", this.brand, this.model, this.yearOfProduction))
                .append(String.format("%d HP, 100 m/h in %d s%n", this.getHorsepower(), this.getAcceleration()))
                .append(String.format("%d Suspension force, %d Durability%n", this.getSuspension(), this.getDurability())).toString();
    }
}
