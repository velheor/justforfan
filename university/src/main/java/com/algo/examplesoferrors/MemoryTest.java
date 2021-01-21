package com.algo.examplesoferrors;

import javassist.ClassPool;

public class MemoryTest {
  private static Object v = new Object();
  static ClassPool classPool = ClassPool.getDefault();

  public static void main(String[] args) throws Exception {
    Thread.sleep(15000);
    notObviousRecursion();
  }

  public static void heapErrorWithoutHeap() {
    float[] outOfMemory = new float[999_999_999];
  }

  public static void heapErrorWithObjectsWithoutCollections() {
    while (true) {
      Object c = v;
      v =
          new Object() {
            final float[] q = new float[1000000];
            final float[] w = new float[1000000];
            final float[] e = new float[1000000];
            final Object a = c;
          };
    }
  }

  public static void metaSpaceError() throws Exception {
    for (int i = 0; i < 1000000000; i++) {
      Class c = classPool.makeClass("com.university.examplesoferrors.MemoryTest" + i).toClass();
      System.out.println(c.getName());
    }
  }

  public static void recursion() {
    recursion();
  }

  public static void notObviousRecursion() {
    Object1 object1 = new Object1();
    Object2 object2 = new Object2();

    object1.t = object2;
    object2.t = object1;
    String str = object1.toString();
  }
}

class Object1 {
  Long i;
  Object2 t;

  @Override
  public String toString() {
    return t.toString() + i;
  }
}

class Object2 {
  Long i;
  Object1 t;

  @Override
  public String toString() {
    return t.toString() + i;
  }
}
