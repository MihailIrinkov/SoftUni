package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    public Database database;
    private static final Person[] PEOPLE = {new Person(1, "Boris"),
            new Person(2, "Petar"), new Person(3, "Miroslav")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreatedValidObject() {
        Person[] elements = database.getElements();

        Assert.assertArrayEquals(elements, PEOPLE);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testTrowExceptionWhenLengthMooreThenSixteen() throws OperationNotSupportedException {
        Person[] persons = new Person[17];

        new Database(persons);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] persons = new Person[0];

        new Database(persons);
    }

    @Test
    public void testAddOperationIsSuccessful() throws OperationNotSupportedException {

        Person testPerson = new Person(4, "Teo");

        database.add(testPerson);
        Person[] persons = database.getElements();

        Assert.assertEquals(PEOPLE.length + 1, persons.length);

        //Assert.assertEquals(persons[persons.length - 1], testPerson);

        Assert.assertEquals(Integer.valueOf(
                persons[persons.length - 1].getId()), Integer.valueOf(4));

        Assert.assertEquals(persons[persons.length - 1].getUsername(), "Teo");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionWhenNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemovingOfElementOnTheLastIndex() throws OperationNotSupportedException {

        database.remove();

        Person[] persons = database.getElements();
//
//        Assert.assertEquals(persons.length, PEOPLE.length - 1);
//
//        Person removedPerson = PEOPLE[PEOPLE.length - 2];
//        Assert.assertEquals(persons[persons.length - 1], removedPerson);

        Assert.assertEquals(Integer
                .valueOf(persons[persons.length - 1].getId()), Integer.valueOf(2));

        Assert.assertEquals(persons[persons.length - 1].getUsername(), "Petar");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
//        for (int i = 0; i < PEOPLE.length; i++) {
//            database.remove();
//        }

        database = new Database();

        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUsernameIsNullThrowException() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Petar");

        Assert.assertEquals(2, person.getId());
        Assert.assertEquals("Petar", person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowExceptionWhenDatabaseEmpty() throws OperationNotSupportedException {
        database = new Database();
        Person person = new Person(5, "Tester");

        database.findByUsername(person.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameMooreThenOnePerson() throws OperationNotSupportedException {
        Person person = new Person(4, "Miroslav");
        database.add(person);

        database.findByUsername("Miroslav");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByNameInvalidUsername() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }

    @Test
    public void testFindUserById() throws OperationNotSupportedException {
        Person person = database.findById(1);

        Assert.assertEquals(1, person.getId());
        Assert.assertEquals("Boris", person.getUsername());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMooreThenOneId() throws OperationNotSupportedException {
        database.add(new Person(3, "Pesho"));

        database.findById(3);
    }

     @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
     }
}