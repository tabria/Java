package inferno_infinity.engine;

import inferno_infinity.annotations.Review;
import inferno_infinity.enumerations.Gem;
import inferno_infinity.factory.WeaponFactory;
import inferno_infinity.interfaces.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Commands {

    private Map<String, Weapon> weapons;

    public Commands() {
        this.weapons = new HashMap<>();
    }

    void createWeapon(String weaponType, String weaponName){
        this.weapons.putIfAbsent(weaponName, WeaponFactory.createWeapon(weaponType, weaponName));
    }

    void addGem(String weaponName, int socketIndex, String gemType){
        if (this.weapons.containsKey(weaponName)){
            Gem gem = Gem.valueOf(gemType);
            this.weapons.get(weaponName).addGemToWeapon(socketIndex, gem);
        }
    }

    void removeGem(String weaponName, int socketIndex){
        if (this.weapons.containsKey(weaponName)){
            this.weapons.get(weaponName).removeGemFromWeapon(socketIndex);
        }
    }

    public String printWeapon(String weaponName) {
        if (this.weapons.containsKey(weaponName)){
           return this.weapons.get(weaponName).toString();
        }
        return "";
    }

    public String compareWeapon(String firstWeaponName, String secondWeaponName) {

        if (this.weapons.containsKey(firstWeaponName) && this.weapons.containsKey(secondWeaponName)){
            if (this.weapons.get(firstWeaponName).compareTo(this.weapons.get(secondWeaponName)) >=0) {
                return String.format("%s (Item Level: %.1f)",this.weapons.get(firstWeaponName).toString(),this.weapons.get(firstWeaponName).getItemLevel());
            } else {
                return String.format("%s (Item Level: %.1f)",this.weapons.get(secondWeaponName).toString(),this.weapons.get(secondWeaponName).getItemLevel());
            }
        }
        return "";
    }

    public Review getAnnotation() {
        return (Review) Weapon.class.getAnnotation(Review.class);

    }
}
