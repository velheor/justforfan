package com.algo;

import java.util.Arrays;

public class SumParts {

  public static int[] sumParts(int[] ls) {

    int a = Arrays.stream(ls).sum();

    int[] result = new int[ls.length + 1];

    for (int i = 0; i < ls.length; i++) {
      result[i] = a;
      a -= ls[i];
    }

    return result;
  }
}
