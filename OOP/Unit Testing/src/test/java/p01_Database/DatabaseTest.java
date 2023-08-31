package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Calendar;

import static org.junit.Assert.*;

public class DatabaseTest {

    private static  Database database;

    @Before
    public void init() throws OperationNotSupportedException {
       database = new Database(8,9,10);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestSetElementsShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test()
    public void TestSetElementsShouldWorkProperly() throws OperationNotSupportedException {


        Integer[] expected = database.getElements();
        Integer[] actual = new Integer[]{8,9,10};

        assertArrayEquals(actual,expected);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void TestAddShouldThrowException() throws OperationNotSupportedException {
        database.add(null);

     }

    @Test
    public void TestAddShouldWordProperly() throws OperationNotSupportedException {
        Integer value = 11;
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
    public void TestGetElementsShouldWorkProperly() throws OperationNotSupportedException {
        Integer [] expected = {8,9,10};

        assertArrayEquals(expected,database.getElements());



    }

}