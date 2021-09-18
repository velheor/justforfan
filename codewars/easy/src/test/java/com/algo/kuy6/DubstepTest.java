package com.algo.kuy6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.algo.kuy6.Dubstep;
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