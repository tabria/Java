package pizza_calories;

public class Dough {

    private static final double WHITE_MODIFIER = 1.5;
    private static final double WHOLEGRAIN_MODIFIER = 1.0;
    private static final double CRISPY_MODIFIER = 0.9;
    private static final double CHEWY_MODIFIER = 1.1;
    private static final double HOMEMADE_MODIFIER = 1.0;
    private static final String STRING_DEFAULT = "";
    private static final double DOUBLE_DEFAULT = 0.0;


    private String flowerType;
    private String doughTechnic;
    private double weight;
    private double modifierFlower;
    private double modifierTechnic;


    public Dough() {
        this.flowerType=STRING_DEFAULT;
        this.doughTechnic=STRING_DEFAULT;
        this.weight=DOUBLE_DEFAULT;
        this.modifierFlower=DOUBLE_DEFAULT;
        this.modifierTechnic = DOUBLE_DEFAULT;
    }

    void setFlowerType(String flower) {
        if(!"white".equalsIgnoreCase(flower) && !"wholegrain".equalsIgnoreCase(flower)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flowerType = flower;
        setModifierFlower();
    }

    void setDoughTechnic(String technic) {
        if(!"crispy".equalsIgnoreCase(technic) && !"chewy".equalsIgnoreCase(technic) && !"homemade".equalsIgnoreCase(technic)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.doughTechnic = technic;
        setModifierTechnic();
    }

    void setWeight(double weight) {
        if (weight<1 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setModifierFlower() {
        switch(flowerType.toLowerCase()) {
            case "white":
                this.modifierFlower = WHITE_MODIFIER;
                break;
            case "wholegrain":
                this.modifierFlower = WHOLEGRAIN_MODIFIER;
                break;
        }
    }

    private void setModifierTechnic() {
        switch(this.doughTechnic.toLowerCase()){
            case "crispy":
                this.modifierTechnic = CRISPY_MODIFIER;
                break;
            case "chewy":
                this.modifierTechnic = CHEWY_MODIFIER;
                break;
            case "homemade":
                this.modifierTechnic = HOMEMADE_MODIFIER;
                break;
        }
    }

    double getWeight() {
        return this.weight;
    }

    double getModifierFlower() {
        return this.modifierFlower;
    }

    double getModifierTechnic() {
        return this.modifierTechnic;
    }
}
