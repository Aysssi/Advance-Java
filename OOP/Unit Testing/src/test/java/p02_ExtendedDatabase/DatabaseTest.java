package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static Database database;

    @Before
    public void init() throws OperationNotSupportedException {
        database = new Database(new Person(1,"Desi"),
                new Person(2,"Maria"),
                new Person(3,"Iva"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestSetElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test
    public void TestSetElementsShouldWorkProperly()  {


        Person[] expected = database.getElements();
        Person[] actual = new Person[]{new Person(1,"Desi")
                ,new Person(2,"Maria"),new Person(3,"Iva")};

        assertArrayEquals(actual,expected);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestAddShouldThrowException() throws OperationNotSupportedException {
        database.add(null);

    }

    @Test
    public void TestAddShouldWordProperly() throws OperationNotSupportedException {
       Person value = new Person(4,"Georgi");
        int expectedLength = database.getElements().length +1;

        database.add(value);

        assertNotNull(database.getElements());
        assertEquals(expectedLength,database.getElements().length);
        assertEquals(value,database.getElements()[database.getElements().length -1]);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestRemoveShouldThrowException() throws OperationNotSupportedException {

        database.remove();
        database.remove();
        database.remove();
        database.remove();


    }
    @Test
    public void TestRemoveShouldWordProperly() throws OperationNotSupportedException {

        int expectedLength = database.getElements().length -1;

        database.remove();
        assertEquals(expectedLength,database.getElements().length);

    }
    @Test
    public void TestGetElementsShouldWorkProperly() {
        Person [] expected =new Person[]{new Person(1,"Desi"),
                new Person(2,"Maria"),
                new Person(3,"Iva")};;

        assertArrayEquals(expected,database.getElements());



    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByUsernameShouldThrowExceptionIfNameIsNull() throws OperationNotSupportedException {

     database.findByUsername(null);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByUsernameShouldThrowExceptionIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(4, "Maria"));
        database.findByUsername("Maria");

    }
    @Test
    public void TestFindByUsernameShouldWorkProperly() throws OperationNotSupportedException {

        Person expected = new Person(2,"Maria");
        Person actual = database.findByUsername("Maria");

        assertEquals(expected,actual);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByIdShouldThrowExceptionIfNotMatch() throws OperationNotSupportedException {

        database.findById(4);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestFindByIdShouldThrowExceptionIfDuplicate() throws OperationNotSupportedException {
        database.add(new Person(2,"Gosho"));
        database.findById(2);

    }
    @Test
    public void TestFindByIdShouldWorkProperly() throws OperationNotSupportedException {

        Person expected =  new Person(1, "Desi");
        Person actual = database.findById(1);

        assertEquals(expected,actual);

    }
}
