package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DubstepTest {

  @Test
  public void Test1() {
    assertEquals("ABC", Dubstep.solution("WUBWUBABCWUB"));
  }

  @Test
  public void Test2() {
    assertEquals("R L", Dubstep.solution("RWUBWUBWUBLWUB"));
  }
}