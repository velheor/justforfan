package com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Printer {

  public static String printerError(String s) {
    List<Character> list = new ArrayList<Character>();
    Set<Character> used = new HashSet<>();

    int i = 0;
    for (char c : s.toCharArray()) {
      list.add(Character.toLowerCase(c));
    }

    for (char c : list) {
      if (used.add(c)) {
        if (c > 109) {
          i += Collections.frequency(list, c);
        }
      }
    }
    return i + "/" + list.size();
  }
}
