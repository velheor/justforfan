package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dubstep {

  public static String solution(String song) {
    List<String> result = new ArrayList<>(Arrays.asList(song.split("WUB")));
    result.removeAll(Arrays.asList("", null));
    return result.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  public static String solutionBetter(String song) {
    return song.replaceAll("(WUB)+", " ").trim();
  }
}
