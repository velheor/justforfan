package com.algo.kuy6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Validate {

    public static boolean solution(String n) {

        String[] strings = n.split("");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        if (array.length % 2 == 0) {
            for (int i = array.length - 2; i >= 0; i -= 2) {
                array[i] *= 2;
                if (array[i] > 9) {
                    array[i] -= 9;
                }
            }
        } else {
            for (int i = array.length - 1; i >= 0; i -= 2) {
                array[i] *= 2;
                if (array[i] > 9) {
                    array[i] -= 9;
                }
            }
        }

        return IntStream.of(array).sum() % 10 == 0;
    }
}
