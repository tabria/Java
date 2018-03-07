package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Target;
import rpg_lab.Weapon;

import java.util.ArrayList;
import java.util.List;

public class DummyTests {

    private static final int DUMMY_NORMAL_HEALTH_POINTS = 10;
    private static final int DUMMY_NOTMAL_XP_POINTS = 9;
    private static final int DEAD_DUMMY_HEALTH = 0;

    private static final int ATTACK_POINTS = 3;

    private static final List<Weapon> WEAPONS =  new ArrayList<Weapon>(){{
            add(new Axe(10, 10));
            add(new Axe(20, 20));
            add(new Axe(30, 30));
    }};

    private Target dummy;


    @Test
    public void testDummyLoosingHealthAfterAttack(){
        this.dummy= new Dummy(DUMMY_NORMAL_HEALTH_POINTS, DUMMY_NOTMAL_XP_POINTS, WEAPONS);

        this.dummy.takeAttack(ATTACK_POINTS);
        this.dummy.takeAttack(ATTACK_POINTS);

        Assert.assertEquals("Dummy do not loose health correctly", 4, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackDeadDummyThrowError(){
        this.dummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_NOTMAL_XP_POINTS, WEAPONS);

        this.dummy.takeAttack(ATTACK_POINTS);

    }

    @Test
    public void testKilledDummyGivesXP(){
        this.dummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_NOTMAL_XP_POINTS, WEAPONS);

        this.dummy.giveExperience();

        Assert.assertEquals("Dummy does not give XP", 9, this.dummy.giveExperience());
    }


    @Test(expected = IllegalStateException.class)
    public void testAlliveDummyMustNotGivesXP(){
        this.dummy = new Dummy(DUMMY_NORMAL_HEALTH_POINTS, DUMMY_NOTMAL_XP_POINTS, WEAPONS);

        this.dummy.giveExperience();

    }


}
