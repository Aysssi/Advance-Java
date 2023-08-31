package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

     private static ListIterator listIterator;

     @Before
     public void  init () throws OperationNotSupportedException {
         listIterator = new ListIterator("Alex","Iva");
     }
    @Test(expected = OperationNotSupportedException.class)
    public void TestConstructorShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void TestConstructorShouldWorkProperly() throws OperationNotSupportedException {

        listIterator.move();
        listIterator.move();
        assertFalse(listIterator.hasNext());

    }
    @Test
    public void TestHasNextShouldReturnFalse()  {

       listIterator.move();
       assertFalse(listIterator.hasNext());
    }

    @Test
    public void TestHasNextShouldReturnTrue()  {

      assertTrue(listIterator.hasNext());

    }
    @Test
    public void TestMoveShouldReturnFalse()  {

        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void TestMoveShouldReturnTrue()  {

        assertTrue(listIterator.hasNext());

    }

    @Test(expected = IllegalStateException.class)
    public void TestPrintShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void TestPrintShouldWorkProperly()   {

       String expected = "Alex";
       String actual = listIterator.print();

       assertEquals(expected,actual);

    }
}