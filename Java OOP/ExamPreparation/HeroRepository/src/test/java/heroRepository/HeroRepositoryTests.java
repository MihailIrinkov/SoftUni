package heroRepository;

import org.junit.Assert;
import org.junit.Test;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository

    @Test
    public void testGetCount() {
        HeroRepository heroRepository1 = new HeroRepository();
        Assert.assertEquals(0, heroRepository1.getCount());
        Hero hero1 = new Hero("boko", 10);
        heroRepository1.create(hero1);
        Assert.assertEquals(1, heroRepository1.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroWhenNull() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = null;
        heroRepository1.create(hero1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWhenExist() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero("boko", 10);
        heroRepository1.create(hero1);
        heroRepository1.create(hero1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveHeroWhenNameNull() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero(null, 10);
        heroRepository1.remove(hero1.getName());
    }

    @Test
    public void testRemoveHero() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero("boko", 10);
        heroRepository1.create(hero1);
        Assert.assertTrue(heroRepository1.remove(hero1.getName()));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero("boko", 10);
        Hero hero2 = new Hero("4oko", 20);
        heroRepository1.create(hero1);
        heroRepository1.create(hero2);
        Assert.assertEquals(hero2, heroRepository1.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero("boko", 10);
        Hero hero2 = new Hero("4oko", 20);
        heroRepository1.create(hero1);
        heroRepository1.create(hero2);
        Assert.assertEquals(hero1, heroRepository1.getHero(hero1.getName()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroes() {
        HeroRepository heroRepository1 = new HeroRepository();
        Hero hero1 = new Hero("boko", 10);
        Hero hero2 = new Hero("4oko", 20);
        heroRepository1.create(hero1);
        heroRepository1.create(hero2);

        heroRepository1.getHeroes().remove(0);
    }

}
