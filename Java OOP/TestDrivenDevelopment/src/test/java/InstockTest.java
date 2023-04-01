import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    @Test
    public void testContainsAndAdd() {
        Product product = new Product("water", 1.20, 2);

        Assert.assertFalse(this.stock.contains(product));

        this.stock.add(product);
        Assert.assertTrue(this.stock.contains(product));
    }

    @Test
    public void testGetCount() {

        Assert.assertEquals(0, this.stock.getCount());

        fillStock();

        Assert.assertEquals(3, this.stock.getCount());
    }

    @Test
    public void testFindProduct() {

        fillStock();

        Product foundedProduct = this.stock.find(2);

        Assert.assertEquals(foundedProduct.getLabel(), "cheese");
        Assert.assertEquals(foundedProduct.getQuantity(), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWhenIndexGreater() {

        fillStock();

        this.stock.find(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThrowExWhenIndexNegative() {

        fillStock();

        this.stock.find(-1);
    }

    @Test
    public void testChangeQuantitySuccessfulUpdate() {

        fillStock();
        Product productBread = this.stock.find(1);
        this.stock.changeQuantity("bread", 9);

        Assert.assertEquals(productBread.getQuantity(), 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWhenNotFoundThrowEx() {
        fillStock();

        this.stock.changeQuantity("juce", 5);
    }

    @Test
    public void testFindByLabel() {
        fillStock();

        Product expectedProduct = this.stock.find(0);

        Product receivedProduct = this.stock.findByLabel("water");

        Assert.assertEquals(expectedProduct.getLabel(), receivedProduct.getLabel());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testFindByLabelWhenInvalidLabelThrowEx() {
        fillStock();
        this.stock.findByLabel("potato");
    }

    @Test
    public void testFindFirstByAlphabeticalOrderCorrectCount() {
        fillStock();
        Iterable<Product> iterable = this
                .stock.findFirstByAlphabeticalOrder(2);

        int countProducts = 0;
        for (Product p : iterable) {
            countProducts++;
        }

        Assert.assertEquals(2, countProducts);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderSorted() {
        List<String> expectedSorting = new ArrayList<>();

        Product product1 = new Product("water", 1.20, 2);
        Product product2 = new Product("bread", 1.90, 3);
        Product product3 = new Product("cheese", 4.20, 5);

        this.stock.add(product1);
        expectedSorting.add(product1.getLabel());
        this.stock.add(product2);
        expectedSorting.add(product2.getLabel());
        this.stock.add(product3);
        expectedSorting.add(product3.getLabel());

        expectedSorting = expectedSorting.stream().sorted().collect(Collectors.toList());

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(3);

        List<String> iterableSorting = new ArrayList<>();

        for (Product p : iterable) {
            iterableSorting.add(p.getLabel());
        }
        Assert.assertEquals(iterableSorting, expectedSorting);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderInvalidCount() {
        fillStock();

        Iterable<Product> iterable = this.stock.findFirstByAlphabeticalOrder(5);

        List<Product> productsList = getProductList(iterable);

        Assert.assertTrue(productsList.isEmpty());
    }

    @Test
    public void testFindAllInRange() {
        fillStock();

        Iterable<Product> iterable = this.stock.findAllInRange(1.10, 4.90);

        int countProductsInRange = 0;

        for (Product p : iterable) {
            countProductsInRange++;
        }

        Assert.assertEquals(3, countProductsInRange);
    }

    @Test
    public void testFindAllInRangeSorted() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllInRange(1.10, 4.10);

        List<Product> products = getProductList(iterable);

        Assert.assertEquals("bread", products.get(0).getLabel());
        Assert.assertEquals("water", products.get(1).getLabel());
    }

    @Test
    public void testFindAllInRangeWhenNoMatches() {
        fillStock();

        Iterable<Product> iterable = this.stock.findAllInRange(9.20, 12.90);
        Assert.assertFalse(iterable.iterator().hasNext());
    }

    @Test
    public void testFindAllByPrice() {
        fillStock();

        Iterable<Product> iterable = this.stock.findAllByPrice(4.20);

        List<Product> productList = getProductList(iterable);
        Assert.assertEquals(1, productList.size());
        Assert.assertEquals("cheese", productList.get(0).getLabel());
    }

    @Test
    public void testFindAllByPriceWhenNoWereFound() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByPrice(6.90);

        Assert.assertFalse(iterable.iterator().hasNext());
    }

    @Test
    public void testFindAllByQuantity() {
        fillStock();
        Iterable<Product> iterable = this.stock.findAllByQuantity(5);

        List<Product> productList = getProductList(iterable);
        Assert.assertEquals(1, productList.size());
        Assert.assertEquals("cheese", productList.get(0).getLabel());

    }

    @Test
    public void testFindAllByQuantityWhenNoProductFound() {
        fillStock();

        Iterable<Product> iterable = this.stock.findAllByQuantity(15);
        Assert.assertFalse(iterable.iterator().hasNext());
    }

    @Test
    public void testIterator() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product("water", 1.20, 2);
        productList.add(product1);
        Product product2 = new Product("bread", 1.90, 3);
        productList.add(product2);
        Product product3 = new Product("cheese", 4.20, 5);
        productList.add(product3);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
        Iterator<Product> iterator = this.stock.iterator();
        List<Product> returnedProducts = new ArrayList<>();

        while (iterator.hasNext()) {
            returnedProducts.add(iterator.next());
        }

        Assert.assertEquals(productList, returnedProducts);

    }

    public void fillStock() {
        Product product1 = new Product("water", 1.20, 2);
        Product product2 = new Product("bread", 1.90, 3);
        Product product3 = new Product("cheese", 4.20, 5);

        this.stock.add(product1);
        this.stock.add(product2);
        this.stock.add(product3);
    }

    private List<Product> getProductList(Iterable<Product> iterable) {
        List<Product> products = new ArrayList<>();

        for (Product p : iterable) {
            products.add(p);
        }
        return products;
    }
}