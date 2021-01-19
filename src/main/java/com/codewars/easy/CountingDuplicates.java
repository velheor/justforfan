package com.codewars.easy;

import java.util.*;

public class CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("abcd"));
    }

    public static int duplicateCount(String text) {
        List<Character> list = new ArrayList<Character>();
        Set<Character> used = new HashSet<>();
        int i = 0;
        for(char c : text.toCharArray()) {
            list.add(Character.toLowerCase(c));
        }

        for (char c : list) {
            if(used.add(c)) {
                if(Collections.frequency(list, c)>1){
                   i++;
                }
            }
        }
        return i;
    }
}
