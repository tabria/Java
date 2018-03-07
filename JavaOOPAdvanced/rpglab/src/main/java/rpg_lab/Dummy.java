package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Dummy implements Target {

    private int health;
    private int experience;
    private List<Weapon> loot;

    public Dummy(int health, int experience, List<Weapon> loot) {
        this.health = health;
        this.experience = experience;
        this.loot = loot;
    }

    public int getHealth() {
        return this.health;
    }

    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public Weapon dropLoot(RandomProvider rnd) {
        int index = rnd.next(this.loot.size());
        return this.loot.get(index);
    }
}
