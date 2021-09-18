package com.algo.kuy6;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {

    public static String[] solution(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder split = new StringBuilder();

        for (int i = 0; i < s.toCharArray().length; i++) {
            split.append(s.toCharArray()[i]);
            if (s.toCharArray().length % 2 != 0 && i == (s.toCharArray().length - 1)) {
                split.append("_");
            }
            if (split.length() == 2) {
                result.add(split.toString());
                split = new StringBuilder();
            }
        }

        return result.toArray(String[]::new);
    }
}
