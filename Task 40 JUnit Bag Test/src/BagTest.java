import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class BagTest {
    private Bag<Integer> bag;

    @Before
    public void setUp() {
        bag = new Bag<Integer>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
    }

    @Test
    public void testGrab() {
        Integer grabbedItem = bag.grab();
        assertTrue(bag.contains(grabbedItem));
    }

    @Test
    public void testGrabWithIndex() {
        Integer grabbedItem = bag.grab(1);
        assertEquals(new Integer(2), grabbedItem);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGrabOnEmptyBag() {
        Bag<Integer> emptyBag = new Bag<>();
        emptyBag.grab();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGrabWithInvalidIndex() {
        bag.grab(3);
    }

    @Test
    public void testAdd() {
        assertTrue(bag.add(4));
        assertTrue(bag.contains(4));
    }

    @Test
    public void testRemoveWithIndex() {
        assertTrue(bag.remove(1));
        assertFalse(bag.contains(2));
    }

    @Test
    public void testRemoveWithItem() {
        assertTrue(bag.remove(new Integer(2)));
        assertFalse(bag.contains(2));
    }

    @Test
    public void testContains() {
        assertTrue (bag.contains(1));
        assertFalse(bag.contains(4));
    }

    @Test
    public void testIsEmpty() {
        Bag<Integer> emptyBag = new Bag<Integer>();
        assertTrue(emptyBag.isEmpty());
        assertFalse(bag.isEmpty());
    }

    @Test
    public void testClear() {
        bag.clear();
        assertTrue(bag.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(3, bag.size());
        bag.add(4);
        assertEquals(4, bag.size());
    }

    @Test
    public void testIterator() {
        Iterator<Integer> it = bag.iterator();
        assertTrue(it.hasNext());
        assertEquals(new Integer(1), it.next());
        assertTrue(it.hasNext());
        assertEquals(new Integer(2), it.next());
        assertTrue(it.hasNext());
        assertEquals(new Integer(3), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testToArray() {
        Integer[] expectedArray = {1, 2, 3};
        assertArrayEquals(expectedArray, bag.toArray());
    }

    @Test
    public void testToString() {
        String expectedString = "[1, 2, 3]";
        assertEquals(expectedString, bag.toString());
    }
}
