package university.examplesoferrors;

public class MemoryTest {

    public static void main(String[] args) {
        float[] outOfMemory = new float[999_999_999];
    }
}
