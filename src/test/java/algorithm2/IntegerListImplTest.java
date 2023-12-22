package algorithm2;

import algorithm1.ElementNotFoundException;
import algorithm1.ListIndexOutOfBoundsException;
import algorithm1.ListIsFullException;
import algorithm1.NullItemException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerList list;

    @BeforeEach
    void setUp() {
        list = new IntegerListImpl(5);
    }

    @Test
    void methodShouldThrowNullItemException() {
        assertThrows(NullItemException.class, () -> list.add(null));
    }

    @Test
    void methodShouldThrowListIsFullException() {
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(-4);

        assertThrows(ListIsFullException.class, () -> list.add(7));
    }

    @Test
    void methodShouldThrowElementNotFoundException() {
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(-4);

        assertThrows(ElementNotFoundException.class, () -> list.remove((Integer) 3));
    }

    @Test
    void methodShouldThrowListIndexOutOfBoundsException() {
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(9);
        list.add(-4);
        assertThrows(ListIndexOutOfBoundsException.class, () -> list.get(-8));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 9, 7})
    void methodShouldAddInteger(Integer item) {
        Integer actual = list.add(item);
        assertEquals(actual, item);
        assertEquals(1, list.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"2,9"})
    void methodShouldAddIntegerByIndex(int index, Integer item) {
        list.add(13);
        list.add(78);
        list.add(56);
        list.add(index, item);
        assertEquals(4, list.size());
        assertEquals(9, list.get(index));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,45"})
    void methodShouldReplaceItem(int index, Integer item) {
        list.add(13);
        list.add(78);
        list.add(56);
        list.set(index, item);
        assertEquals(3, list.size());
        assertEquals(45, list.get(index));
    }

    @Test
    void methodShouldRemoveItem() {
        list.add(13);
        list.add(78);
        list.add(56);
        list.remove((Integer) 78);
        assertEquals(2, list.size());
        assertFalse(list.contains(78));
    }

    @Test
    void methodShouldRemoveItemByIndex() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.remove(1);
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
    }

    @Test
    void methodShouldCheckIfObjectContainsItem() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertTrue(list.contains(6));
    }

    @Test
    void methodShouldFindItemByIndexFromBeginning() {
        list.add(14);
        list.add(2);
        list.add(6);
        assertEquals(2, list.indexOf(6));
    }

    @Test
    void methodShouldFindItemByIndexFromEnd() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertEquals(3, list.lastIndexOf(14));
    }

    @Test
    void methodShouldReturnItemByIndex() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertEquals(14, list.get(3));
    }

    @Test
    void methodShouldCompareTwoObjects() {
        IntegerListImpl list2 = new IntegerListImpl(5);
        list2.add(14);
        list2.add(2);
        list2.add(6);
        list2.add(14);
        list2.add(3);
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertTrue(list2.equals(list));
    }

    @Test
    void methodShouldReturnCorrectSize() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertEquals(5, list.size());
    }

    @Test
    void methodShouldCheckIfListIsEmpty() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertFalse(list.isEmpty());
    }

    @Test
    void methodShouldClearList() {
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void methodShouldConvertToArray() {
        int[] expected = {14, 2, 6, 14, 3};
        list.add(14);
        list.add(2);
        list.add(6);
        list.add(14);
        list.add(3);
        assertArrayEquals(expected, list.toArray());
    }
}