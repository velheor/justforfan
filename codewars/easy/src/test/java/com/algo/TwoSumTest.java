package com.algo;

import static java.util.Objects.deepEquals;

import org.junit.jupiter.api.Test;

class TwoSumTest {

  @Test
  void solution() {
    deepEquals(new int[] {0, 2}, TwoSum.solution(new int[] {1, 2, 3}, 4));
  }
}
