package hell.entities.heroes;

public class Wizard extends BaseHero {

    private static final long STRENGTH =25;
    private static final long AGILITY = 25;
    private static final long INTELLIGENCE = 100;
    private static final long HITPOINTS = 100;
    private static final long DAMAGE =250;

    public Wizard(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, HITPOINTS, DAMAGE);
    }
}
