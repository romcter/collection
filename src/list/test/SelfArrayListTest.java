package list.test;

import list.SelfList;
import list.User;
import list.arrayList.SelfArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelfArrayListTest {

    SelfList<User> list = new SelfArrayList<>();
    User userRoman = new User("Roman");
    User userDen = new User("Den");
    User userEugen = new User("Eugen");
    User userJulia = new User("Julia");

    User userUnknown = new User("Unknown");

    @AfterEach
    void afterEach() {
        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    void testAdd() {
        assertTrue(list.add(userRoman));
        assertTrue(list.contain(userRoman));
    }

    @Test
    void testContain() {
        list.add(userRoman);
        assertTrue(list.contain(userRoman));

        assertFalse(list.contain(userUnknown));
    }

    @Test
    void testIndexOf(){

        int indexMoreThanSize = list.indexOf(userUnknown);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(indexMoreThanSize));

        addDataToList();
        int indexEugen = list.indexOf(userEugen);
        assertEquals(2, indexEugen);

        int indexUnknown = list.indexOf(userUnknown);
        assertEquals(-1, indexUnknown);
    }

    @Test
    void testGetByIndex() {
        addDataToList();

        int indexJulia = list.indexOf(userJulia);
        User userJulia = list.get(indexJulia);
        assertEquals(this.userJulia, userJulia);
    }

    @Test
    void testRemoveByIndex() {
        addDataToList();

        int index = list.indexOf(userEugen);
        assertTrue(list.remove(index));
        assertNotEquals(list.get(index), userEugen);
        assertEquals(-1, list.indexOf(userEugen));
    }

    @Test
    void testRemoveByItem() {
        addDataToList();

        assertTrue(list.remove(userEugen));
        assertFalse(list.contain(userEugen));
        assertEquals(-1, list.indexOf(userEugen));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());

        addDataToList();
        assertEquals(4, list.size());

        list.remove(userDen);
        assertEquals(3, list.size());
    }

    @Test
    void clear() {
        addDataToList();
        assertEquals(4, list.size());
        assertTrue(list.clear());
        assertEquals(0, list.size());
    }

    private void addDataToList(){
        list.add(userRoman);
        list.add(userDen);
        list.add(userEugen);
        list.add(userJulia);
    }
}
