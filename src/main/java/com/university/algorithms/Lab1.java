package com.university.algorithms;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    private String pat; // образец
    private long patHash; // хеш-значение образца
    private int M; // длина образца
    private long Q; // большое простое число
    private int R = 127; // размер алфавита
    private long RM; // R^(M-1) % Q

    public Lab1(String pat) {
        this.pat = pat; // сохранение образца
        M = pat.length();
        Q = longRandomPrime();
        RM = 1;
        // вычисление R^(M-1) % Q для удаления старшей цифры
        for (int i = 1; i <= M - 1; i++)
            RM = (R * RM) % Q;
        patHash = hash(pat, M);
    }

    public boolean check(int i) {
        return true;
    }

    // вычисление хэша
    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }

    private int search(String txt) {
        // поиск хэш-значения в тексте
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash)
            return 0;
        for (int i = M; i < N; i++) {
            // Удаление старшей цифры добавление младшей цифры и проверка на совпадение
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash)
                if (check(i - M + 1))
                    return i - M + 1;
        }
        return N;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Rabin Karp Algorithm Test");
        System.out.println("Enter Text");
        String text = sc.nextLine();
        System.out.println("Enter Pattern");
        String pattern = sc.nextLine();
        System.out.println("Results :");
        System.out.println(new Lab1(pattern).search(text));
    }
}
