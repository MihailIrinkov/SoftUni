package shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    // TODO

    @Test(expected = UnsupportedOperationException.class)
    public void testGetShelves() {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");

        shop1.getShelves().remove("B");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsContainsKey()
            throws OperationNotSupportedException {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");
        Map<String, Goods> shelves = new LinkedHashMap<>();
        shelves.put("boko", goods1);
        shop1.addGoods("invalid_shelve", goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsWhenNull() throws OperationNotSupportedException {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");

        shop1.addGoods("Shelves1", goods1);
        shop1.addGoods("Shelves1", goods1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsWhenExist() throws OperationNotSupportedException {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");

        Map<String, Goods> shelves = new LinkedHashMap<>();
        shelves.put("Shelves1", goods1);
        shop1.addGoods("Shelves1", goods1);
        shop1.addGoods("Shelves2", goods1);

    }

    @Test
    public void testAddGoods() throws OperationNotSupportedException {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");

        Map<String, Goods> shelves = new LinkedHashMap<>();
        shelves.put("Shelves1", goods1);

        String actualMassage = shop1.addGoods("Shelves1", goods1);

        String massage = "Goods: B is placed successfully!";
        Assert.assertEquals(massage, actualMassage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWhenShelveNotExisting() {
        Shop shop1 = new Shop();
        shop1.removeGoods("Shelves_test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsWhenNoGoods() {
        Shop shop1 = new Shop();

        Goods goods1 = new Goods("boko", "B");
        Goods goods2 = new Goods("4oko", "4");
        shop1.removeGoods("Shelves1", goods2);
    }

    @Test
    public void testRemoveGoodsSuccessfully() throws OperationNotSupportedException {
        Shop shop1 = new Shop();
        Goods goods1 = new Goods("boko", "B");
        shop1.addGoods("Shelves1", goods1);
        String actualMassage = shop1.removeGoods("Shelves1", goods1);

        String expectedMassage = "Goods: B is removed successfully!";

        Assert.assertEquals(expectedMassage, actualMassage);
        Assert.assertEquals(null, shop1.getShelves().get("Shelves1"));
    }

}