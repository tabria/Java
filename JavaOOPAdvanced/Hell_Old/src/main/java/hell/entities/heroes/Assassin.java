package hell.entities.heroes;

public class Assassin extends BaseHero {

    private static final long STRENGTH =25;
    private static final long AGILITY = 100;
    private static final long INTELLIGENCE = 15;
    private static final long HITPOINTS = 150;
    private static final long DAMAGE =300;

    public Assassin(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE, HITPOINTS, DAMAGE);
    }
}
