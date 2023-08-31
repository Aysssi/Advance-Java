package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void TestSortCorrect(){

        int [] actual = {7,8,1,5,6};
        int [] expected = {1,5,6,7,8};

        Bubble.sort(actual);

        assertArrayEquals(expected,actual);
    }
    @Test
    public void TestSortIncorrect(){

        int [] actual = {7,8,1,5,6};
        int [] expected = {1,7,6,5,8};

        Bubble.sort(actual);

        assertNotEquals(expected,actual);
    }
}