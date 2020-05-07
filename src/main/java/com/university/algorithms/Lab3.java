package com.university.algorithms;

public class Lab3 {
    public static void main(String[] argv) {
        int[] buyer = {1, 5, 20};
        int[] seller = {100};
        int[] allmoney = unionTwoMassives(buyer, seller);

        insertionSort(allmoney);

        int s = 0;
        int i = 1;

        while (i <= buyer.length && allmoney[i] <= (s + 1)) {
            s = s + allmoney[i];
            i = i + 1;
        }

        System.out.println(s);
    }

    public static int[] unionTwoMassives(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int count = 0;

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            count++;
        }
        for (int j = 0; j < b.length; j++) {
            c[count++] = b[j];
        }

        return c;
    }

    public static void insertionSort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Integer v, Integer w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}