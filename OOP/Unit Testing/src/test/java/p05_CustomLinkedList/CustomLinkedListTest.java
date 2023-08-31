package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    public static CustomLinkedList<String > linkedList;

    @Before
    public void init(){
        linkedList = new CustomLinkedList<>();
        linkedList.add("Alex");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestGetShouldThrowException(){

        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(1);
    }
    @Test
    public void TestGetShouldWorkProperly(){

        String expected = "Alex";
        String actual = linkedList.get(0);

        assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestSetShouldThrowException(){

       linkedList.set(2,"Dani");
    }

    @Test
    public void TestSetShouldWorkProperly(){

       String expected = "Iva";
       linkedList.set(0,"Iva");
       String actual = linkedList.get(0);

       assertEquals(expected,actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddIfListIsEmpty(){

        CustomLinkedList<String > customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Dani");
        String expected = "Dani";
        String actual = linkedList.get(1);

        assertEquals(expected,actual);
    }

    @Test
    public void TestAddIfNotEmptyList(){

        linkedList.add("Dani");
        linkedList.add("Viki");

       assertEquals( 2,linkedList.indexOf("Viki"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveAtShouldThrowException(){

       linkedList.removeAt(4);
    }

    @Test
    public void TestRemoveAtShouldWorkProperly(){
        linkedList.add("Dani");

       String actual = linkedList.removeAt(1);

       assertEquals("Dani", actual);

    }
}