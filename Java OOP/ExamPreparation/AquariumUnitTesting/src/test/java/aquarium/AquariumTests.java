package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    @Test
    public void testGetName() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);

        Assert.assertEquals("SoftUni", aquarium1.getName());
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameWhenNull() {
        Aquarium aquarium = new Aquarium(null, 50);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNameWhenWhitespace() {
        Aquarium aquarium = new Aquarium("     ", 50);
    }

    @Test
    public void testGetCapacity() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Assert.assertEquals(50, aquarium1.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenBelowZero() {
        Aquarium aquarium1 = new Aquarium("SoftUni", -50);
    }

    @Test
    public void testGetCount() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish("prash4o");
        Assert.assertEquals(0, aquarium1.getCount());
        aquarium1.add(fish1);
        Assert.assertEquals(1, aquarium1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishWhenNoCapacity() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 0);
        Fish fish1 = new Fish("prash4o");
        aquarium1.add(fish1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFishNull() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish(null);
        aquarium1.remove(fish1.getName());
    }

    @Test
    public void testRemoveFish() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish("prash4o");
        aquarium1.add(fish1);
        aquarium1.remove(fish1.getName());
        Assert.assertEquals(0, aquarium1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishWhenNull() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish(null);
        aquarium1.sellFish(fish1.getName());
    }

    @Test
    public void testSellFish() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish("prash4o");
        aquarium1.add(fish1);
        aquarium1.sellFish(fish1.getName());

        Assert.assertEquals(false, fish1.isAvailable());
    }

    @Test
    public void testReport() {
        Aquarium aquarium1 = new Aquarium("SoftUni", 50);
        Fish fish1 = new Fish("prash4o");
        Fish fish2 = new Fish("som");
        aquarium1.add(fish1);
        aquarium1.add(fish2);

        Assert.assertEquals("Fish available at SoftUni: prash4o, som",
                aquarium1.report());
    }

}

