package com.interview;

public class FinalClassTesting {
    public static void main(String[] args) {
        final int test;
        // ok
        test = 1;
        // bad
        test = 2;
    }
}
