package com.algo.kuy6;

import static org.junit.jupiter.api.Assertions.*;

import com.algo.kuy6.DRoot;
import org.junit.jupiter.api.Test;

class DRootTest {

  @Test
  void digital_root() {
    assertEquals(7, DRoot.digital_root(16));
    assertEquals(6, DRoot.digital_root(456));
  }
}
