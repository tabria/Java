package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Hero implements HeroI {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<Weapon>();
    }

    public Iterable<Weapon> getInventory() {
        return this.inventory;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target, RandomProvider rand) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.dropLoot(rand));
        }
    }
}
