package com.university.algorithms;

import java.util.Scanner;

public class Lab2 {

    private static String getAnswer() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static Double[] randomArray(int n) {
        Double[] array = new Double[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 1000;
        }
        return array;
    }

    public static void main(String[] argv) {
        Double[] array = new Double[Integer.parseInt(getAnswer())];
        selection(array);
        insertion(array);
        shaker(array);
        heap(array);
        quicksort(array, 0, array.length - 1);

    }

    private static boolean less(Double v, Double w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Double[] a, int i, int j) {
        Double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void selection(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
                exch(a, i, min);
            }
        }
    }

    public static void insertion(Double[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }


    public static void shaker(Double[] a) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    public static void heap(Double[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    public static void heapify(Double[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый = 2*i + 1
        int r = 2 * i + 2; // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* This function partitions a[] in three parts
       a) a[l..i] contains all elements smaller than pivot
       b) a[i+1..j-1] contains all occurrences of pivot
       c) a[j..r] contains all elements greater than pivot */
    public static void partition(Double[] a, int l, int r, int i, int j) {
        i = l - 1;
        j = r;
        int p = l - 1, q = r;
        Double v = a[r];

        while (true) {
            // From left, find the first element greater than
            // or equal to v. This loop will definitely terminate
            // as v is last element
            while (a[++i] < v) ;

            // From right, find the first element smaller than or
            // equal to v
            while (v < a[--j])
                if (j == l)
                    break;

            // If i and j cross, then we are done
            if (i >= j) break;

            // Swap, so that smaller goes on left greater goes on right
            exch(a, i, j);

            // Move all same left occurrence of pivot to beginning of
            // array and keep count using p
            if (a[i] == v) {
                p++;
                exch(a, p, i);
            }

            // Move all same right occurrence of pivot to end of array
            // and keep count using q
            if (a[j] == v) {
                q--;
                exch(a, j, q);
            }
        }

        // Move pivot element to its correct index
        exch(a, i, r);

        // Move all left same occurrences from beginning
        // to adjacent to arr[i]
        j = i - 1;
        for (int k = l; k < p; k++, j--)
            exch(a, k, j);

        // Move all right same occurrences from end
        // to adjacent to arr[i]
        i = i + 1;
        for (int k = r - 1; k > q; k--, i++)
            exch(a, i, k);
    }

    // 3-way partition based quick sort
    public static void quicksort(Double[] a, int l, int r) {
        if (r <= l) return;

        int i = 0, j = 0;

        // Note that i and j are passed as reference
        partition(a, l, r, i, j);

        // Recur
        quicksort(a, l, j);
        quicksort(a, i, r);
    }
}