package magicGame;


import org.junit.Assert;
import org.junit.Test;

public class MagicianTests {
    //TODO

    @Test
    public void testGetUserName() {
        Magician magician1 = new Magician("boko", 10);
        Assert.assertEquals("boko", magician1.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserNameWhenNull() {
        Magician magician1 = new Magician(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUserNameWhenWhiteSpace() {
        Magician magician1 = new Magician("      ", 10);
    }

    @Test
    public void testGetHealth() {
        Magician magician1 = new Magician("boko", 10);
        Assert.assertEquals(10, magician1.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHeathBelowZero() {
        Magician magician1 = new Magician("boko", -10);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetCollectionUnmodifiable() {
        Magician magician1 = new Magician("boko", 10);
        magician1.getMagics().remove(0);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetDamageWhenHealthNotGreaterThenZero() {
        Magician magician1 = new Magician("boko", 0);
        magician1.takeDamage(10);
    }

    @Test
    public void testGetDamage() {
        Magician magician1 = new Magician("boko", 10);
        magician1.takeDamage(2);
        Assert.assertEquals(8, magician1.getHealth());

        magician1.takeDamage(10);
        Assert.assertEquals(0, magician1.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicWhenMagicNull() {
        Magician magician1 = new Magician("boko", 10);
        magician1.addMagic(null);
    }

    @Test
    public void testAddMagic() {
        Magician magician1 = new Magician("boko", 10);
        Magic magic = new Magic("first", 10);
        magician1.addMagic(magic);
        Assert.assertEquals(magic, magician1.getMagics().get(0));
    }

    @Test
    public void testRemoveMagic() {
        Magician magician1 = new Magician("boko", 10);
        Magic magic = new Magic("first", 10);
        magician1.addMagic(magic);

        Assert.assertEquals(1, magician1.getMagics().size());

        boolean isRemoved = magician1.removeMagic(magic);
        Assert.assertEquals(0, magician1.getMagics().size());
        Assert.assertTrue(isRemoved);
    }

    @Test
    public void testGetMagic() {
        Magician magician1 = new Magician("boko", 10);
        Magic magic = new Magic("first", 10);
        magician1.addMagic(magic);

        Assert.assertEquals(magic, magician1.getMagic("first"));
    }

}
