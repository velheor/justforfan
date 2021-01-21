package com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DescendingOrder {
  public static int sortDesc(int num) {
    List<Integer> numbers = new ArrayList<>();
    while (num != 0) {
      numbers.add(num % 10);
      num /= 10;
    }

    Collections.sort(numbers);
    Collections.reverse(numbers);

    for (int i : numbers) {
      num *= 10;
      num += i;
    }

    return num;
  }
}
