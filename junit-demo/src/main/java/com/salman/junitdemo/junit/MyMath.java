package com.salman.junitdemo.junit;

public class MyMath {
    // {1,2,3} ==> 1 + 2 + 3
    public int calculateSum(int [] numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
