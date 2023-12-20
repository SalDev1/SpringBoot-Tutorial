package list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void test() {
        List listMock = mock(List.class);

        // listMock.size() => 3
        when(listMock.size()).thenReturn(3);
        // Check if the size of the list is 3 or not.
        assertEquals(3 , listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        // listMock.size() --> 3
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    void specificParameters() {
        List listMock = mock(List.class);

        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString",listMock.get(0));
        // If the list doesn't have 0 , in that then return 1.
        assertEquals(null , listMock.get(1));
    }

    @Test
    void genericParameters() {
        List listMock = mock(List.class);

        when(listMock.get(Mockito.anyInt())).thenReturn("SomeString");
        // If the list gets any integer number , then return that particular string.
        assertEquals("SomeString",listMock.get(0));
        // If the list doesn't have 0 , in that then return 1.
        assertEquals("SomeString" , listMock.get(1));
    }
}
