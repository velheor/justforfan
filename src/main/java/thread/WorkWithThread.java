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
            array[i] = Math.random() * 100;
        }
        return array;
    }

    private static double[] calculate(double[] a) {
        long m = currentTimeMillis();
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                outputInConsole("ban");
            }
            b[i] += Math.pow(a[i], 1.789);
        }
        outputInConsole("Time without threads " + (currentTimeMillis() - m));
        return b;
    }

    private static double[] threadsCalculate(double[] a) {
        long m = currentTimeMillis();
        double[] b = new double[a.length];
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i <= a.length / 2; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    outputInConsole("ban");
                }
                b[i] += Math.pow(a[i], 1.789);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = (a.length / 2) + 1; i < a.length; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    outputInConsole("ban");
                }
                b[i] += Math.pow(a[i], 1.789);
            }
        });
        thread1.start();
        thread2.start();
        outputInConsole("Time with threads " + (currentTimeMillis() - m));
        return b;
    }

    private static void sout(double[] a) {
        for (int i = 0; i < a.length; i++) {
            outputInConsole(Double.toString(a[i]));
        }
    }

    public static void main(String[] args) {
        outputInConsole("Input size of array");
        double[] array = randomArray(Integer.parseInt(getAnswer()));
        threadsCalculate(array);
        calculate(array);
    }
}
