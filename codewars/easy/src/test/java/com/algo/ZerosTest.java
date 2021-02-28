package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ZerosTest {

  @Test
  void solution() {
    assertEquals(0, Zeros.solution(0));
    assertEquals(1, Zeros.solution(6));
    assertEquals(2, Zeros.solution(14));
  }
}