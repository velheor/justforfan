package com.algo.kuy6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import com.algo.kuy6.StringSplit;
import org.junit.jupiter.api.Test;

class StringSplitTest {

  @Test
  void solution() {
    String b = "abcde";
    String s = "abcdef";
    String s1 = "HelloWorld";
    assertEquals("[ab, cd, ef]", Arrays.toString(StringSplit.solution(s)));
    assertEquals("[He, ll, oW, or, ld]", Arrays.toString(StringSplit.solution(s1)));
    assertEquals("[ab, cd, e_]", Arrays.toString(StringSplit.solution(b)));
  }
}
