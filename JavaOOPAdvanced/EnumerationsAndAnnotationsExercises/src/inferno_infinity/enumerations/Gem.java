package inferno_infinity.enumerations;

public enum Gem {

    RUBY(7, 2, 5), EMERALD(1, 4, 9), AMETHYST(2, 8, 4);

    private int gemStrength;
    private int gemAgility;
    private int gemVitality;

    Gem(int gemStrength, int gemAgility, int gemVitality) {
        this.gemStrength = gemStrength;
        this.gemAgility = gemAgility;
        this.gemVitality = gemVitality;
    }

    public int getGemStrength() {
        return this.gemStrength;
    }

    public int getGemAgility() {
        return this.gemAgility;
    }

    public int getGemVitality() {
        return this.gemVitality;
    }
}
