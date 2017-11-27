package inferno_infinity.factory;

import inferno_infinity.entities.WeaponImpl;
import inferno_infinity.enumerations.WeaponTypes;
import inferno_infinity.interfaces.Weapon;

public final class WeaponFactory {


    public static Weapon createWeapon(String type, String name){
        return new WeaponImpl(name, WeaponTypes.valueOf(type).getMinDamage(), WeaponTypes.valueOf(type).getMaxDamage(), WeaponTypes.valueOf(type).getSockets());
    }
}
