package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class AxeTests {

    private static final int WEAPON_ATTACK_POINTS = 10;
    private static final int WEAPON_DURABILITY_POINT = 10;

    private static final int DUMMY_HEALTH_POINT = 7;
    private static final int DUMMY_XP_POINTS = 5;

    private static final int WEAPON_NO_DURABILITY_POINTS = 0;

    private Weapon weapon;
    private Target dummy;

    @Before
    public void createDummy(){
        this.dummy = Mockito.mock(Target.class);
    }


    @Test
    public void testWeaponLoosePointsOnNormalDummy(){
       this.weapon = new Axe(WEAPON_ATTACK_POINTS, WEAPON_DURABILITY_POINT);

        this.weapon.attack(this.dummy);

        Assert.assertEquals("Durability not changing correctly", 9, this.weapon.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenWeapon(){
        this.weapon = new Axe(WEAPON_ATTACK_POINTS, WEAPON_NO_DURABILITY_POINTS);

        this.weapon.attack(this.dummy);

    }

}
