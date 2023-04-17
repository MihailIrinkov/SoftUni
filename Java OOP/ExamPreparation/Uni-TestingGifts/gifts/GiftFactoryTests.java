package gifts;

import org.junit.Assert;
import org.junit.Test;

public class GiftFactoryTests {

    @Test
    public void testGetCount() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("boko", 10);

        Assert.assertEquals(0, giftFactory1.getCount());
        giftFactory1.createGift(gift1);
        Assert.assertEquals(1, giftFactory1.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftWhenGiftExist() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("boko", 10);
        giftFactory1.createGift(gift1);
        giftFactory1.createGift(gift1);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWhenTypeNull() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift(null, 10);

        Assert.assertEquals(0, giftFactory1.getCount());
        giftFactory1.createGift(gift1);
        giftFactory1.removeGift(gift1.getType());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWhenTypeWhiteSpace() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("   ", 10);

        Assert.assertEquals(0, giftFactory1.getCount());
        giftFactory1.createGift(gift1);
        giftFactory1.removeGift(gift1.getType());
    }

    @Test
    public void testRemoveGift() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("boko", 10);

        giftFactory1.createGift(gift1);
        giftFactory1.removeGift(gift1.getType());
        Assert.assertEquals(0, giftFactory1.getCount());
    }

    @Test
    public void testGetPresentWithLeastMagic() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("boko", 10);
        Gift gift2 = new Gift("4oko", 20);

        giftFactory1.createGift(gift1);
        giftFactory1.createGift(gift2);

        Assert.assertEquals(gift1, giftFactory1.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresent() {
        GiftFactory giftFactory1 = new GiftFactory();
        Gift gift1 = new Gift("boko", 10);
        Gift gift2 = new Gift("4oko", 20);

        giftFactory1.createGift(gift1);
        giftFactory1.createGift(gift2);

        Assert.assertEquals(gift1, giftFactory1.getPresent(gift1.getType()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPresents() {
        GiftFactory giftFactory1 = new GiftFactory();
        giftFactory1.getPresents().remove(null);
    }

}
