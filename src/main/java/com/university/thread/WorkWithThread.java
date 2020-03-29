package thread;

import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

public class WorkWithThread {
    private static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void outputInConsole(String str) {
        System.out.println(str);
    }

    private static double[] randomArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 1000;
        }
        return array;
    }

    private static double[] calculate(double[] a, int k) {
        long m = currentTimeMillis();
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < k; j++)
                b[i] += Math.pow(a[i], 1.789);
        }
        outputInConsole("Time without threads " + (currentTimeMillis() - m));
        return b;
    }

    private static double[] threadsCalculate(double[] a, int k) {
        long m = currentTimeMillis();
        double[] b = new double[a.length];
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a.length / 3; i++) {
                for (int j = 0; j < k; j++)
                    b[i] += Math.pow(a[i], 1.789);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = (a.length / 3); i < a.length - (a.length / 3); i++) {
                for (int j = 0; j < k; j++) {
                }
                b[i] += Math.pow(a[i], 1.789);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = a.length - a.length / 3; i < a.length; i++) {
                for (int j = 0; j < k; j++) {
                }
                b[i] += Math.pow(a[i], 1.789);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            outputInConsole("ban");
        }
        outputInConsole("Time with threads " + (currentTimeMillis() - m));
        return b;
    }

    private static void sout(double[] a) {
        for (int i = 0; i < a.length; i++) {
            outputInConsole(Double.toString(a[i]));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        outputInConsole("Input size of array and difficulty");
        double[] array = randomArray(Integer.parseInt(getAnswer()));
        int k = Integer.parseInt(getAnswer());
        threadsCalculate(array, k);
        calculate(array, k);
    }
}
