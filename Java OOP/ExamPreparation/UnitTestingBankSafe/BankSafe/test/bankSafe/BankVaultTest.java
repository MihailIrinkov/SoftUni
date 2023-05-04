package bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    //TODO: Write your tests here

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCells() {
        BankVault bankVault1 = new BankVault();

        bankVault1.getVaultCells().remove("A1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemKeyInvalid() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        bankVault1.addItem("D10", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWhenCellTaken() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        Item item1 = new Item("Boko", "99");
        Item item2 = new Item("4oko", "119");

        bankVault1.addItem("A1", item1);
        bankVault1.addItem("A1", item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemWhenItemAlreadyExist() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        Item item1 = new Item("Boko", "99");
        Item item2 = new Item("4oko", "99");

        bankVault1.addItem("A1", item1);
        bankVault1.addItem("A2", item1);
    }

    @Test
    public void testAddItem() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        Item item1 = new Item("Boko", "99");
        Item item2 = new Item("4oko", "007");

        //bankVault1.addItem("A1", item1);

//        Assert.assertEquals("99", bankVault1.getVaultCells().get("A1").getItemId());
//        Assert.assertEquals("Item:99 saved successfully!",
//                String.format("Item:%s saved successfully!", item1.getItemId()));

        String expected = "Item:99 saved successfully!";
        String actual = bankVault1.addItem("A1", item1);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemKeyInvalid() {
        BankVault bankVault1 = new BankVault();
        bankVault1.removeItem("D100", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemWhenNoItem() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        Item item1 = new Item("Boko", "99");
        Item item2 = new Item("4oko", "99");

        bankVault1.addItem("A1", item1);
        bankVault1.addItem("A2", item2);
        bankVault1.removeItem("A1", item2);
    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException {
        BankVault bankVault1 = new BankVault();
        Item item1 = new Item("Boko", "99");
        Item item2 = new Item("4oko", "007");

        bankVault1.addItem("A1", item1);
        bankVault1.addItem("A2", item2);

        String actual = bankVault1.removeItem("A1", item1);
        String expected = "Remove item:99 successfully!";
        Assert.assertEquals(null, bankVault1.getVaultCells().get("A1"));
        Assert.assertEquals(expected, actual);

//        Assert.assertEquals("Remove item:99 successfully!",
//                String.format("Remove item:%s successfully!", item1.getItemId()));
    }

//    @Test
//    public void test() {
//
//    }

}