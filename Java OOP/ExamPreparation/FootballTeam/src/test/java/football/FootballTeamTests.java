package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test
    public void testGetName() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 250);

        Assert.assertEquals("SoftUni", footballTeam.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameNull() {
        FootballTeam footballTeam = new FootballTeam(null, 250);
    }

    @Test
    public void testGetVacation() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 250);

        Assert.assertEquals(250, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionLessThenZero() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", -5);
    }

    @Test
    public void testGetCount() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 250);
        footballTeam.addFootballer(new Footballer("Pesho"));

        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerWhenNoVacantPosition() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 2);
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerWhenNull() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 3);
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));

        footballTeam.removeFootballer("Kolio");
    }

    @Test
    public void testRemoveFootballer() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 3);
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));

        footballTeam.removeFootballer("Pesho");
        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWhenNull() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 3);
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));

        Footballer noneInList = new Footballer("Kolio");

        footballTeam.footballerForSale("Kolio");
    }

    @Test
    public void testFootballerForSale() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 3);
        Footballer pesho = new Footballer("Pesho");
        footballTeam.addFootballer(pesho);
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));

        footballTeam.footballerForSale("Pesho");

        Assert.assertEquals(false, pesho.isActive());
    }

    @Test
    public void testGetStatistics() {
        FootballTeam footballTeam = new FootballTeam("SoftUni", 3);
        footballTeam.addFootballer(new Footballer("Pesho"));
        footballTeam.addFootballer(new Footballer("Tosho"));
        footballTeam.addFootballer(new Footballer("Gosho"));

        Assert.assertEquals("The footballer Pesho, Tosho, Gosho is in the team SoftUni.",
                footballTeam.getStatistics());
    }
}
