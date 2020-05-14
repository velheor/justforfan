package com.university.algorithms;

import java.util.Arrays;

public class Lab3 {
    public static void main(String[] argv) {
        Integer[] buyer = {5, 1, 2};
        Integer[] seller = {4};
        int price = 8;
        int amountOfMoney = sumOfMoney(unionTwoMassives(buyer, seller));
        Integer[] canBuy = new Integer[amountOfMoney];

        Arrays.fill(canBuy, 0);
        canBuy[0] = 1;
        for (Integer coin : buyer) {
            for (int i = amountOfMoney-1; i > 0; i--) {
                if ((canBuy[i] == 1) && ((i + coin) <= amountOfMoney)) {
                    canBuy[i + coin] = 1;
                }
            }
            canBuy[coin] = 1;
        }
        for (Integer coin : seller) {
            for (int i = 0; i < amountOfMoney; i++) {
                if (canBuy[i] == 1 && coin <= i) {
                    canBuy[i - coin] = 1;
                }
            }
        }
        if (canBuy[price] == 1) {
            System.out.println("Yes");
        } else
            System.out.println("No");
    }

    public static int sumOfMoney(Integer[] allMoney) {
        int sum = 0;
        for (int num : allMoney) {
            sum = sum + num;
        }
        return sum;
    }

    public static Integer[] unionTwoMassives(Integer[] a, Integer[] b) {
        Integer[] c = new Integer[a.length + b.length];

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

    public static void insertionSort(Integer[] a) {
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

    private static void exch(Integer[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

