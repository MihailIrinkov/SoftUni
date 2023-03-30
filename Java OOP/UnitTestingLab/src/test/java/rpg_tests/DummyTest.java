package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTest {

    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 20;
    private static final int DEAD_DUMMY_HEALTH = 0;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void createDummy() {
        dummy = new Dummy(HEALTH, EXPERIENCE);
        deadDummy = new Dummy(DEAD_DUMMY_HEALTH, EXPERIENCE);
    }

    @Test
    public void testAttackedDummyLosesHealth() {
        dummy.takeAttack(ATTACK_POINTS);

        Assert.assertEquals(80, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsException() {
//        Dummy dummy = new Dummy(0, 10);
//
//        dummy.takeAttack(1);
//
//        Assert.assertEquals(0, dummy.getHealth());


        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveXP() {
        int exp = deadDummy.giveExperience();

        Assert.assertEquals(10, exp);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyCantGiveXP() {
        dummy.giveExperience();
    }
}
