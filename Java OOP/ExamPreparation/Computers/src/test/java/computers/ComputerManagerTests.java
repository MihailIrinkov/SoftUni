package computers;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.validation.Validator;
import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        ComputerManager computerManager1 = new ComputerManager();
        computerManager1.getComputers().remove(null);
    }

    @Test
    public void testGetCount() {
        ComputerManager computerManager1 = new ComputerManager();
        Assert.assertEquals(0, computerManager1.getCount());

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        computerManager1.addComputer(computer1);
        Assert.assertEquals(1, computerManager1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWhenComputerExist() {
        ComputerManager computerManager1 = new ComputerManager();
        Assert.assertEquals(0, computerManager1.getCount());

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWhenNull() {
        ComputerManager computerManager1 = new ComputerManager();
        computerManager1.addComputer(null);
    }

    @Test
    public void testAddComputer() {
        ComputerManager computerManager1 = new ComputerManager();
        Assert.assertEquals(0, computerManager1.getCount());

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        computerManager1.addComputer(computer1);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer2);
        Assert.assertEquals(2, computerManager1.getCount());
    }

    @Test
    public void testRemoveComputer() {
        ComputerManager computerManager1 = new ComputerManager();
        Assert.assertEquals(0, computerManager1.getCount());

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer2);

        Assert.assertEquals(2, computerManager1.getCount());
        Computer removedComp = computerManager1.removeComputer("Dell",
                "Pro");
        Assert.assertEquals(1, computerManager1.getCount());

        Assert.assertEquals(removedComp, computer2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWhenManufacturerNull() {
        ComputerManager computerManager1 = new ComputerManager();

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer2);
        computerManager1.getComputer(null, "PPP");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWhenModelNull() {
        ComputerManager computerManager1 = new ComputerManager();

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer2);
        computerManager1.getComputer("Dell", null);
    }

    @Test
    public void testGetComputer() {
        ComputerManager computerManager1 = new ComputerManager();

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer2);

        Assert.assertEquals(computer2,
                computerManager1.getComputer("Dell", "Pro"));
    }

    @Test
    public void testGetComputersByManufacturer() {
        ComputerManager computerManager1 = new ComputerManager();

        Computer computer1 = new Computer("Pravetz",
                "8C", 10);
        Computer computer2 = new Computer("Dell",
                "Pro", 20);
        computerManager1.addComputer(computer1);
        computerManager1.addComputer(computer2);

        List<Computer> expectedComp = computerManager1
                .getComputersByManufacturer("Dell");

        Assert.assertEquals(expectedComp,
                computerManager1.getComputersByManufacturer("Dell"));
        Assert.assertEquals(expectedComp.get(0).getManufacturer(),
                computer2.getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateNullValue() {
        ComputerManager computerManager1 = new ComputerManager();

        Computer computer1 = new Computer(null, "8C", 10);
        computerManager1.addComputer(computer1);
        computerManager1.getComputersByManufacturer(computer1.getManufacturer());
    }

}