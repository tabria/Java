package inferno_infinity.entities;

import inferno_infinity.enumerations.Gem;
import inferno_infinity.interfaces.Weapon;

import java.util.Arrays;
import java.util.Objects;

public class WeaponImpl implements Weapon, Comparable<Weapon> {

    private String name;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;
    private int strength;
    private int agility;
    private int vitality;

    public WeaponImpl(String name, int minDamage, int maxDamage, int gemSlots) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = new Gem[gemSlots];
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public Gem[] getSockets() {
        return this.sockets;
    }

    private int calculateStrengthPoints(){
        return Arrays.stream(this.getSockets()).filter(Objects::nonNull).mapToInt(Gem::getGemStrength).sum();
    }
    private int calculateAgilityPoints(){
        return Arrays.stream(this.getSockets()).filter(Objects::nonNull).mapToInt(Gem::getGemAgility).sum();
    }

    private int calculateVitalityPoints(){
        return Arrays.stream(this.getSockets()).filter(Objects::nonNull).mapToInt(Gem::getGemVitality).sum();
    }

    private int calculateMinDamage(int strengthPoint, int agilityPoints){
        return this.getMinDamage() + (strengthPoint*2) + agilityPoints;
    }

    private int calculateMaxDamage(int strengthPoints, int agilityPoints){
        return this.getMaxDamage() + (strengthPoints*3) +(agilityPoints*4);
    }

    @Override
    public double getItemLevel(){
        int strengthPoints = this.calculateStrengthPoints();
        int agilityPoints = this.calculateAgilityPoints();
        int vitalityPoints = this.calculateVitalityPoints();

        int minDamage = this.calculateMinDamage(strengthPoints, agilityPoints);
        int maxDamage = this.calculateMaxDamage(strengthPoints, agilityPoints);

        return ((minDamage + maxDamage) / 2.0) + strengthPoints + agilityPoints + vitalityPoints;

    }

    @Override
    public void addGemToWeapon(int index, Gem gem) {
        if (index >= 0 && index <= this.sockets.length-1){
            this.sockets[index] = gem;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeGemFromWeapon(int index) {
        if ( index>= 0 && index <= this.sockets.length-1 && this.sockets[index] != null){
            this.sockets[index] = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int compareTo(Weapon other) {
        return (int)(this.getItemLevel() - other.getItemLevel());
    }

    @Override
    public String toString() {

        int strengthPoints = this.calculateStrengthPoints();
        int agilityPoints = this.calculateAgilityPoints();
        int vitalityPoints = this.calculateVitalityPoints();

        int minDamage = this.calculateMinDamage(strengthPoints, agilityPoints);
        int maxDamage = this.calculateMaxDamage(strengthPoints, agilityPoints);

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality", this.getName(), minDamage, maxDamage, strengthPoints, agilityPoints, vitalityPoints);
    }
}
