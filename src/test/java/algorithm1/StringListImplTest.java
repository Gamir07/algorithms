package algorithm1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private StringListImpl list;

    @BeforeEach
    void setUp() {
        list = new StringListImpl(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "good", "bad"})
    void methodShouldSuccessfullyAddString(String item) {
        String actual = list.add(item);
        assertEquals(item, actual);
        assertEquals(1, list.size());
    }

    @Test
    void methodShouldThrowNullItemException() {
        assertThrows(NullItemException.class, () -> list.add(null));
    }

    @Test
    void methodShouldThrowListIsFullException() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("worse");
        list.add("man");

        assertThrows(ListIsFullException.class, () -> list.add("girl"));
    }

    @Test
    void methodShouldThrowElementNotFoundException() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("worse");
        list.add("man");

        assertThrows(ElementNotFoundException.class, () -> list.remove("girl"));
    }

    @Test
    void methodShouldThrowListIndexOutOfBoundsException() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("worse");
        list.add("man");
        assertThrows(ListIndexOutOfBoundsException.class, () -> list.get(-8));
    }

    @ParameterizedTest
    @CsvSource(value = {"1, woman"})
    void methodShouldAddStringWithTwoParameters(int index, String item) {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add(index, item);
        assertEquals(4, list.size());
        assertEquals(item, list.get(index));

    }

    @ParameterizedTest
    @CsvSource(value = {"2, help"})
    void methodShouldReplaceItem(int index, String item) {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.set(index, item);
        assertEquals(3, list.size());
        assertEquals(item, list.get(index));
    }

    @Test
    void methodShouldRemoveItemWithStringParameter() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.remove("bad");
        assertEquals(2, list.size());
        assertFalse(list.contains("bad"));
    }

    @Test
    void methodShouldRemoveItemWithIntParameter() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.remove(1);
        assertEquals(2, list.size());
        assertFalse(list.contains("good"));
    }

    @Test
    void methodShouldReturnTrue() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        assertTrue(list.contains("ok"));
    }

    @Test
    void indexOf() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        assertEquals(1, list.indexOf("good"));
    }

    @Test
    void lastIndexOf() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        assertEquals(3, list.lastIndexOf("ok"));
    }

    @Test
    void get() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("boy");
        assertEquals("boy", list.get(3));
    }

    @Test
    void methodShouldReturnTrueWhileComparingTwoObjects() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        StringListImpl list2 = new StringListImpl(5);
        list2.add("ok");
        list2.add("good");
        list2.add("bad");
        list2.add("ok");
        list2.add("bad");
        assertEquals(list.size(),list2.size());
        assertTrue(list.equals(list2));
    }
    @Test
    void methodShouldReturnFalseWhileComparingTwoObjects() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        StringListImpl list2 = new StringListImpl(5);
        list2.add("ok");
        list2.add("good");
        list2.add("badd");
        list2.add("ok");
        list2.add("bad");
        assertEquals(list.size(),list2.size());
        assertFalse(list.equals(list2));
    }

    @Test
    void methodShouldReturnSize() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        assertEquals(5,list.size());
    }

    @Test
    void methodShouldCheckIfObjectIsEmpty() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        assertFalse(list.isEmpty());
    }

    @Test
    void methodShouldRemoveAllTheStrings() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void methodShouldReturnArray() {
        list.add("ok");
        list.add("good");
        list.add("bad");
        list.add("ok");
        list.add("bad");
        String[] expected = {"ok","good","bad","ok","bad"};
        String[] actualList = list.toArray();
        assertArrayEquals(expected,actualList);
    }
}