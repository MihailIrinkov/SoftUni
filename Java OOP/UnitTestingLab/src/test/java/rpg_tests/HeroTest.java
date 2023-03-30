package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTest {
    
    private static final int EXPECTED_EXP = 10;

//    Target target = new Target() {
//        @Override
//        public int getHealth() {
//            return 0;
//        }
//
//        @Override
//        public void takeAttack(int attackPoints) {
//
//        }
//
//        @Override
//        public int giveExperience() {
//            return 10;
//        }
//
//        @Override
//        public boolean isDead() {
//            return true;
//        }
//    };
//
//    Weapon weapon = new Weapon() {
//        @Override
//        public int getAttackPoints() {
//            return 100;
//        }
//
//        @Override
//        public int getDurabilityPoints() {
//            return 100;
//        }
//
//        @Override
//        public void attack(Target target) {
//
//        }
//    };


    @Test
    public void testHeroGainsXpWhenTargetDies() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(EXPECTED_EXP);

        Hero hero = new Hero("Pesho", weaponMock);

        hero.attack(targetMock);

        Assert.assertEquals(10, hero.getExperience());
    }
}