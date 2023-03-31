package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    public Database database;
    private static final Integer[] NUMBERS = {1, 2, 3, 4, 5, 6};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreatedValidObject() {
        Integer[] elements = database.getElements();

        Assert.assertArrayEquals(elements, NUMBERS);

        Assert.assertEquals(elements.length, NUMBERS.length);
//
//        for (int index = 0; index < elements.length; index++) {
//            Assert.assertEquals(elements[index], NUMBERS[index]);
//        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTrowExceptionWhenLengthMooreThenSixteen() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];

        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];

        new Database(numbers);
    }

    @Test
    public void testAddOperationIsSuccessful() throws OperationNotSupportedException {

        database.add(99);
        Integer[] elements = database.getElements();

        Assert.assertEquals(NUMBERS.length + 1, elements.length);

        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(99));

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemovingOfElementOnTheLastIndex() throws OperationNotSupportedException {

        database.remove();

        Integer[] elements = database.getElements();

        Assert.assertEquals(elements.length, NUMBERS.length - 1);

        Assert.assertEquals(elements[elements.length - 1], Integer.valueOf(5));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }
}