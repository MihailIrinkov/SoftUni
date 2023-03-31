package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {3, 2, 1, 6, 5, 4, 9, 8, 7};

        int[] sortedArr= {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Bubble.sort(arr);

        Assert.assertArrayEquals(sortedArr, arr);
    }
}