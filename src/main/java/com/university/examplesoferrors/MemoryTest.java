package com.university.examplesoferrors;

public class MemoryTest extends ClassLoader {
    private static Object v = new Object();

    MemoryTest() {
        MemoryTest memoryTest = new MemoryTest();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        recursion();
    }

    public static void withoutHeapSpace() {
        float[] outOfMemory = new float[999_999_999];
    }

    public static void bigObjects() {
        while (true) {
            Object c = v;
            v = new Object() {
                Object a = c;
            };
        }
    }

    public void metaspace() {
    }


    public static void recursion() {
        recursion();
    }

    public static void implicitRecursion() {
        MemoryTest memoryTest = new MemoryTest();
    }
}
