package com.university.demostream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoStreamAndLambdas {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<String> strings = Arrays.asList("aaa", "vvv", "ccc");
        search(strings);
    }

    public static Double average(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum) / list.size() * 1.0;
    }

    public static List<String> upperCase(List<String> list) {
        list.replaceAll(String::toUpperCase);
        return list;
    }

    public static List<String> search(List<String> list) {
        return list.stream().filter(word -> (word.startsWith("a") && word.length() == 3)).collect(Collectors.toList());
    }
}
