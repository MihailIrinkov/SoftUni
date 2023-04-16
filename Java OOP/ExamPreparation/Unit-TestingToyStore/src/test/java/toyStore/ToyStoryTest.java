package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ToyStoryTest {
    //TODO: Write your tests here

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelf(){
        ToyStore toyStore1 = new ToyStore();
        toyStore1.getToyShelf().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyKeyNotExisting() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        toyStore1.addToy("Test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddToyShelfNotFree() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        Toy toy1 = new Toy("boko", "1");
        Toy toy2 = new Toy("4oko", "2");
        toyStore1.addToy("A", toy1);
        toyStore1.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToyWhenToyAlreadyExist() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        Toy toy1 = new Toy("boko", "1");
        Toy toy2 = new Toy("4oko", "2");
        toyStore1.addToy("A", toy1);
        toyStore1.addToy("B", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWhenShelfNotExist() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        Toy toy1 = new Toy("boko", "1");
        Toy toy2 = new Toy("4oko", "2");
        toyStore1.addToy("A", toy1);
        toyStore1.addToy("B", toy2);
        toyStore1.removeToy("Z", toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveToyWhenNotToy() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        Toy toy1 = new Toy("boko", "1");
//        Toy toy2 = new Toy("4oko", "2");
//        toyStore1.addToy("A", toy1);
//        toyStore1.addToy("B", toy2);
        toyStore1.removeToy("C", toy1);
    }

    @Test
    public void testRemoveToy() throws OperationNotSupportedException {
        ToyStore toyStore1 = new ToyStore();
        Toy toy1 = new Toy("boko", "1");
        Toy toy2 = new Toy("4oko", "2");
        toyStore1.addToy("A", toy1);
        toyStore1.addToy("B", toy2);
        String expected = toyStore1.removeToy("A", toy1);

        Assert.assertEquals(expected, "Remove toy:1 successfully!");
        Assert.assertEquals(null, toyStore1.getToyShelf().get("A"));
    }


}