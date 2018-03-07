package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rpg_lab.*;

import static org.mockito.Mockito.mock;

public class HeroTests {

    private static final int FAKE_TARGET_START_HEALTH = 10;
    private static final int FAKE_TARGET_START_XP = 5;
    private static final int FAKE_WEAPON_START_ATTACK_POINTS = 15;
    private static final int FAKE_WEAPON_START_DURABILITY_POINTS = 12;

    private static final String HERO_NAME ="Petrokarabanivachevich";

    private Target target ;
    private Weapon weapon;
    private RandomProvider rand;
    private HeroI newHero;


    @Before
    public void createDependencies(){
        this.target = mock(Target.class);
        this.weapon = mock(Weapon.class);
        this.rand = mock(RandomProvider.class);
        this.newHero = new Hero(HERO_NAME,this.weapon);
    }


    @Test
    public void testHeroGainXpFromKilledDummy(){

        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(FAKE_TARGET_START_XP);

        this.newHero.attack(this.target, this.rand);
        Assert.assertEquals("Hero does not add target XP to his XP", FAKE_TARGET_START_XP, this.newHero.getExperience());

    }


    @Test
    public void attackGrantsLootIfTargetIsDead() {
        Mockito.when(this.target.isDead()).thenReturn(true);
        Mockito.when(this.target.dropLoot(this.rand)).thenReturn(this.weapon);

        this.newHero.attack(this.target, this.rand);

        // assert
        for (Weapon weapon : this.newHero.getInventory()) {
            Assert.assertSame("Wrong loot", this.weapon, weapon);
        }
    }

}
