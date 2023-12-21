package com.salman.junitdemo.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {
    List<String> todos = Arrays.asList("AWS" , "Azure" ,"Devops");

    @Test
    void test() {
        boolean test = todos.contains("AWS");
        boolean test2 = todos.contains("GCP");

        // assertEquals(true , test);
        // Exploring different types of assert methods that are present
        // when you are creating unit tests.
        assertTrue(test);
        assertFalse(test2);
        // assertNull, assertNoNull
        assertArrayEquals(new int[] {1,2} , new int[] {2,1});
        
        assertEquals(3,todos.size());
    }

    private void assertFalse(boolean test2) {
    }
}
