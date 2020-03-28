package university.examplesoferrors;

import static java.lang.String.format;

public class MemoryTest extends ClassLoader {
    public static StringBuilder big = new StringBuilder();
    public static void main(String[] args) throws InterruptedException {
        MemoryTest memoryTest = new MemoryTest();
        memoryTest.metaspace();
    }

    public static void withoutHeapSpace() {
        float[] outOfMemory = new float[999_999_999];
    }

    public static void bigObjects() {
        for (int i = 0; i < 999_999_999; i++) {
            big.append(i);
        }
    }

    public void metaspace() {
        byte[] bytes = loadClassData(MemoryTest.class.getName());
        for (int i = 0; i < 999_999_999; i++) {
            defineClass(MemoryTest.class.getName(), bytes, 0, bytes.length);
        }

    }

    private static byte[] loadClassData(String className) {
        byte[] result = className.getBytes();
        return result;
    }

    public static void recursion() {
        recursion();
    }

    public static void implicitRecursion() {
        Object a = new Object();
        Object b = a;
        a = b;
        b = a;
    }
}
