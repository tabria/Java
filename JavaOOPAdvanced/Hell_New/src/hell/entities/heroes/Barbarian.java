package hell.entities.heroes;

public class Barbarian extends BaseHero {

    private static final long STRENGTH =90;
    private static final long AGILITY = 25;
    private static final long INTELLIGENCE = 10;
    private static final long HITPOINTS = 350;
    private static final long DAMAGE =150;

    public Barbarian(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, HITPOINTS, DAMAGE);
    }

}
