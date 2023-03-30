package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {

    private static final int AXE_ATTACK_POINTS = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 0;
    private static final int AXE_LOSE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;

    private Dummy dummy;

    @Before
    public void setup () {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponAttacksLosesDurability(){
        Axe axe = new Axe(AXE_ATTACK_POINTS, AXE_DURABILITY);


        axe.attack(dummy);

        Assert.assertEquals(AXE_DURABILITY - AXE_LOSE_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCanAttack() {
        Axe axe = new Axe(AXE_ATTACK_POINTS, BROKEN_AXE_DURABILITY);

        axe.attack(dummy);
    }

}
