package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship

    @Test
    public void testGetCount() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 2);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);
        Assert.assertEquals(0, spaceship1.getCount());
        spaceship1.add(astronaut1);
        Assert.assertEquals(1, spaceship1.getCount());
    }

    @Test
    public void testCreateSpaceShip() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);
        Assert.assertEquals("Spaceship1", spaceship1.getName());
        Assert.assertEquals(1, spaceship1.getCapacity());
    }

    @Test
    public void testGetName() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);

        Assert.assertEquals("Spaceship1", spaceship1.getName());
    }

    @Test
    public void testGetCapacity() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);

        Assert.assertEquals(1, spaceship1.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautWhenNoSpace() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);
        Astronaut astronaut2 = new Astronaut("astronaut2", 2.2);
        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAstronautWhenExisting() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 5);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);

        spaceship1.add(astronaut1);
        spaceship1.add(astronaut1);
    }

    @Test
    public void testAddAstronaut() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 10);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);
        Astronaut astronaut2 = new Astronaut("astronaut2", 1.1);
        Astronaut astronaut3 = new Astronaut("astronaut3", 1.1);

        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
        spaceship1.add(astronaut3);
        Assert.assertEquals(3, spaceship1.getCount());
    }

    @Test
    public void removeAstronaut() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 10);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);
        Astronaut astronaut2 = new Astronaut("astronaut2", 1.1);
        Astronaut astronaut3 = new Astronaut("astronaut3", 1.1);

        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
        spaceship1.add(astronaut3);

        Assert.assertEquals(3, spaceship1.getCount());
//        boolean isRemove = spaceship1.remove(astronaut1.getName());
//        Assert.assertTrue("true", true);

        spaceship1.remove(astronaut1.getName());
        Assert.assertEquals(2, spaceship1.getCount());
    }

    @Test
    public void removeShouldNotRemoveAstronaut() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 10);
        Astronaut astronaut1 = new Astronaut("astronaut1", 1.1);
        Astronaut astronaut2 = new Astronaut("astronaut2", 1.1);
        Astronaut astronaut3 = new Astronaut("astronaut3", 1.1);

        spaceship1.add(astronaut1);
        spaceship1.add(astronaut2);
        spaceship1.add(astronaut3);

//        boolean isRemove = spaceship1.remove(astronaut1.getName());
//        Assert.assertTrue("true", true);

        spaceship1.remove("Pesho");
        Assert.assertEquals(3, spaceship1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityLessThenZero() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", -1);

    }

    @Test
    public void testSetCapacityLessBiggerThenZero() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 10);
        Assert.assertEquals(10, spaceship1.getCapacity());

    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNull() {
        Spaceship spaceship1 = new Spaceship(null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenWhiteSpace() {
        Spaceship spaceship1 = new Spaceship("     ", 1);
    }

    @Test
    public void testCreateShipShouldWork() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);
        Assert.assertEquals("Spaceship1", spaceship1.getName());
        Assert.assertEquals(1, spaceship1.getCapacity());
    }

    @Test
    public void testSetName() {
        Spaceship spaceship1 = new Spaceship("Spaceship1", 1);
        Assert.assertEquals("Spaceship1", spaceship1.getName());
        Assert.assertEquals(1, spaceship1.getCapacity());
    }
}
