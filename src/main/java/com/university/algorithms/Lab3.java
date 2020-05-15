package com.university.algorithms;

import java.util.Arrays;

public class Lab3 {
    public static void main(String[] argv) {
        Integer[] buyer = {1, 1, 1};
        Integer[] seller = {11};
        int amountOfMoney = sumOfMoney(unionTwoMassives(buyer, seller));
        Integer[] canBuy = new Integer[amountOfMoney];

        Arrays.fill(canBuy, 0);
        canBuy[0] = 1;
        for (Integer coin : buyer) {
            for (int i = amountOfMoney - 1; i > 0; i--) {
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
        for (int i = sumOfMoney(buyer); i > 0; i--) {
            if (canBuy[i] == 0) {
                System.out.println("Can buy but no change");
                System.out.println(i);
                return;
            }
        }
        System.out.println("Can buy all");

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
}


