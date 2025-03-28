import org.apache.commons.lang3.ObjectUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @Before
    public void beforeEach() {
        bst = new BinarySearchTree<>(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(1);
        bst.insert(17);
    }

    @Test
    public void testCreate() {
        assertEquals(Integer.valueOf(5), bst.getRoot().getValue());
    }

    @Test
    public void TestInsert() {
        assertEquals(Integer.valueOf(3), bst.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(7), bst.getRoot().getRight().getValue());
        assertEquals(Integer.valueOf(6), bst.getRoot().getRight().getLeft().getValue());
    }

    @Test
    public void testEachInOrder() {
        List<Integer> elements = new ArrayList<>();

        bst.eachInOrder(e -> elements.add(e));

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(1, 3, 5, 6, 7, 17)
        );

        assertEquals(expected.size(), elements.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), elements.get(i));
        }
    }

    @Test
    public void testContainsTrue() {
        assertTrue(bst.contains(6));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(bst.contains(12));
    }

    @Test
    public void testSearchTrue() {
        BinarySearchTree<Integer> search = bst.search(7);

        bst.insert(8);

        assertEquals(Integer.valueOf(7), search.getRoot().getValue());
        assertEquals(Integer.valueOf(6), search.getRoot().getLeft().getValue());
        assertEquals(Integer.valueOf(17), search.getRoot().getRight().getValue());

        assertTrue(bst.contains(8));
        assertFalse(search.contains(8));
    }

    @Test
    public void testSearchFalse() {
        assertNull(bst.search(8));
    }

    @Test
    public void testRange() {
        List<Integer> range = bst.range(3, 7);
        List<Integer> expected = Arrays.asList(3, 5, 7, 6);

        assertEquals(4, range.size());
        for (Integer value : range) {
            assertTrue(expected.contains(value));
        }
    }

    @Test
    public void testDeleteMin() {
        assertTrue(bst.contains(1));
        bst.deleteMin();
        assertFalse(bst.contains(1));
    }

    @Test
    public void testDeleteMax() {
        assertTrue(bst.contains(17));
        bst.deleteMax();
        assertFalse(bst.contains(17));
    }


    @Test
    public void testCount() {
        assertEquals(6, bst.count());
    }

    @Test
    public void testCountAfterInsert() {
        bst.insert(11);
        assertEquals(7, bst.count());
    }

    @Test
    public void testCountAfterDeleteMin() {
        bst.deleteMin();
        assertEquals(5, bst.count());
    }

    @Test
    public void testCountAfterDeleteMax() {
        bst.deleteMax();
        assertEquals(5, bst.count());
    }

    @Test
    public void testRank() {
        assertEquals(4, bst.rank(7));
    }

    @Test
    public void testRankMinElement() {
        assertEquals(0, bst.rank(-1));
    }

    @Test
    public void testRankEmptyTree() {
        assertEquals(0, new BinarySearchTree<Integer>().rank(17));
    }

    @Test
    public void testFloor() {
        assertEquals(Integer.valueOf(6), bst.floor(7));
    }

    @Test
    public void testEmptyFloor() {
        assertNull(bst.floor(-5));
    }

    @Test
    public void testCeil() {
        assertEquals(Integer.valueOf(7), bst.ceil(6));
    }

    @Test
    public void testEmptyCeil() {
        assertNull(bst.ceil(38));
    }

}
