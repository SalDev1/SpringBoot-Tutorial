package com.salman.junitdemo.test;

import com.salman.junitdemo.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {
    @Test
    void test() {
        // Absence of failure is success.
        // Writing down Test Condition or Assert.

        int[] numbers = {1,2,3};
        MyMath math = new MyMath();
        int res = math.calculateSum(numbers);

        System.out.println(res);
        int expectedRes = 6;
        assertEquals(expectedRes , res);
    }

    @Test
    void test1() {
        // Absence of failure is success.
        // Writing down Test Condition or Assert.

        int[] numbers = {};
        MyMath math = new MyMath();
        int res = math.calculateSum(numbers);

        System.out.println(res);
        int expectedRes = 0;
        assertEquals(expectedRes , res);
    }

    @Test
    void calculateSum_ThreeMemberArray() {
        MyMath math = new MyMath();
        assertEquals(6 , math.calculateSum(new int[] {1,2,3}));
    }

    @Test
    void calculateSum_ZeroLengthArray() {
        MyMath math = new MyMath();
        assertEquals(0, math.calculateSum(new int[] {}));
    }
}
