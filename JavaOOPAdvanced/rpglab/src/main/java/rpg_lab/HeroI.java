package rpg_lab;

public interface HeroI {
    Iterable<Weapon> getInventory();

    int getExperience();

    void attack(Target target, RandomProvider rand);
}
