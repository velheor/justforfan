package com.algo;

public class DRoot {

  public static int digital_root(int n) {
    int result = 0;

    while (n >= 1) {
      result += (n % 10);
      n = n / 10;
    }

    if (result > 9) {
      return digital_root(result);
    }

    return result;
  }
}
