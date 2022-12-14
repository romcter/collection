package list.test;

import list.SelfList;
import list.User;
import list.linkedList.SelfLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelfLinkedListTest {

    SelfList<User> list = new SelfLinkedList();
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

        int indexUnknown = list.indexOf(userUnknown);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(indexUnknown));
    }

    private void addDataToList(){
        list.add(userRoman);
        list.add(userDen);
        list.add(userEugen);
        list.add(userJulia);
    }
}
