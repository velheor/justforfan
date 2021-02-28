package com.algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DRootTest {

  @Test
  void digital_root() {
    assertEquals( 7, DRoot.digital_root(16));
    assertEquals( 6, DRoot.digital_root(456));
  }
}