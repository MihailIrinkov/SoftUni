package farmville;

import org.junit.Assert;
import org.junit.Test;

public class FarmvilleTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Farm

    @Test
    public void testGetCount() {
        Animal animal1 = new Animal("boko", 10);
        Farm farm = new Farm("SoftUni", 10);
        farm.add(animal1);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test
    public void testGetName() {
        Animal animal1 = new Animal("boko", 10);
        Farm farm = new Farm("SoftUni", 10);
        Assert.assertEquals("SoftUni", farm.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenNoCapacity() {
        Animal animal1 = new Animal("boko", 10);
        Animal animal2 = new Animal("4oko", 20);
        Farm farm = new Farm("SoftUni", 1);
        farm.add(animal1);
        farm.add(animal2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenAlreadyExist() {
        Animal animal1 = new Animal("boko", 10);
        Farm farm = new Farm("SoftUni", 10);
        farm.add(animal1);
        farm.add(animal1);
    }

    @Test
    public void testRemoveAnimal() {
        Animal animal1 = new Animal("boko", 10);
        Animal animal2 = new Animal("4oko", 20);
        Farm farm = new Farm("SoftUni", 10);
        farm.add(animal1);
        farm.add(animal2);

        farm.remove(animal1.getType());
        Assert.assertEquals(1, farm.getCount());
        Assert.assertEquals(true,farm.remove(animal2.getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWhenNegativeValue() {
        Farm farm = new Farm("SoftUni", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNull() {
        Farm farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenEmpty() {
        Farm farm = new Farm("     ", 10);
    }

}
