package com.algo.kuy6;

import static org.junit.jupiter.api.Assertions.*;

import com.algo.kuy6.Line;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  public void test1() {
    String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
    int n = 1;
    assertEquals("Sheldon", Line.whoIsNext(names, n));
  }
  @Test
  public void test2() {
    String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
    int n = 6;
    assertEquals("Sheldon", Line.whoIsNext(names, n));
  }
}