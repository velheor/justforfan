package algorithms;

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
        int buff;
        int left = 0;
        int right = a.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (less(a[i + 1], a[i])) {
                    exch(a, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (less(a[i], a[i - 1])) {
                    exch(a, i, i - 1);
                }
            }
            left++;
        } while (left < right);
    }

    /*public static void random(Comparable[] a) {
        for (int i = 0; i < 3; ++i) {
            swap(a[i], a[rand() % 3]);
        }
        quick(a, 0, a.length - 1);
    }*/

    public static void quick(Double[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quick(a, lo, j - 1);
        quick(a, j + 1, hi);
    }

    public static int partition(Double[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Double v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
}