package com.algo.kuy6;

import java.util.*;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        List<Character> list = new ArrayList<>();
        Set<Character> used = new HashSet<>();
        int i = 0;
        for (char c : text.toCharArray()) {
            list.add(Character.toLowerCase(c));
        }

        for (char c : list) {
            if (used.add(c)) {
                if (Collections.frequency(list, c) > 1) {
                    i++;
                }
            }
        }
        return i;
    }
}
