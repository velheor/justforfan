package com.algo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidateTest {

  @Test
  void solution() {
    assertFalse(Validate.solution("0"));
  }

  @Test
  void solution1230() {
    assertTrue(Validate.solution("1230"));
  }

  @Test
  void solution2121() {
    assertTrue(Validate.solution("2121"));
  }

  @Test
  void solution26() {
    assertTrue(Validate.solution("26"));
  }

  @Test
  void solution91() {
    assertTrue(Validate.solution("91"));
  }

  @Test
  void solution123() {
    assertTrue(Validate.solution("123"));
  }
}