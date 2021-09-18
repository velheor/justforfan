package com.algo.kuy6;

public class Line {

    public static String whoIsNext(String[] names, int n) {
        for (int j = 1; ; j *= 2) {
            for (int i = 0; i < names.length; i++) {
                n -= j;
                if (n < 0) {
                    return names[i];
                }
            }
        }
    }
}
