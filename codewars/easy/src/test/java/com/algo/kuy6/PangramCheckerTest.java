package com.algo.kuy6;

import static org.junit.jupiter.api.Assertions.*;

import com.algo.kuy6.PangramChecker;
import org.junit.jupiter.api.Test;

class PangramCheckerTest {

  @Test
  public void test1() {
    String pangram1 = "The quick brown fox jumps over the lazy dog.";
    PangramChecker pc = new PangramChecker();
    assertTrue(pc.solution(pangram1));
  }

  @Test
  public void test2() {
    String pangram2 = "You shall not pass!";
    PangramChecker pc = new PangramChecker();
    assertFalse(pc.solution(pangram2));
  }
}
