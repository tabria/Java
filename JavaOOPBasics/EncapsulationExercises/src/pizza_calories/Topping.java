package pizza_calories;

public class Topping {

    private static final double MEAT_MODIFIER = 1.2;
    private static final double VEGGIES_MODIFIER = 0.8;
    private static final double CHEESE_MODIFIER = 1.1;
    private static final double SAUCE_MODIFIER = 0.9;

    private String toppingType;
    private double weight;
    private double modifier;



    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
        setModifier();
    }

    private String getToppingType() {
        return this.toppingType;
    }

    double getWeight() {
        return this.weight;
    }

    double getModifier() {
        return this.modifier;
    }

    private void setToppingType(String toppingType) {
        if (!"meat".equalsIgnoreCase(toppingType) && !"veggies".equalsIgnoreCase(toppingType)
                && !"cheese".equalsIgnoreCase(toppingType) && !"sauce".equalsIgnoreCase(toppingType)){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(Double weight) {
        if (weight<1 || weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",getToppingType()));
        }
        this.weight = weight;
    }

    private void setModifier() {
        switch(this.toppingType.toLowerCase()){
            case "meat":
                this.modifier = MEAT_MODIFIER;
                break;
            case "veggies":
                this.modifier = VEGGIES_MODIFIER;
                break;
            case "cheese":
                this.modifier = CHEESE_MODIFIER;
                break;
            default:
                this.modifier = SAUCE_MODIFIER;
                break;
        }
    }

}
