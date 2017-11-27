package inferno_infinity.interfaces;

import inferno_infinity.annotations.Review;
import inferno_infinity.enumerations.Gem;

@Review
public interface Weapon extends Comparable<Weapon> {


    double getItemLevel();

    void addGemToWeapon(int index, Gem gem);

    void removeGemFromWeapon(int socketIndex);
}
