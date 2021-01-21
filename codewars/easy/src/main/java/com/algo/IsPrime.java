package com.algo;

public class IsPrime {
  public static boolean checkPrime(int number) {
    if (number == 2 || number == 3) {
      return true;
    } else if (number <= 3) {
      return false;
    } else if (number % 2 == 0 || number % 3 == 0) {
      return false;
    }
    int i = 5;
    while (i * i <= number) {
      if (number % i == 0 || number % (i + 2) == 0) {
        return false;
      }
      i += 6;
    }
    return true;
  }
}
