package com.algo.algorithms;

import java.util.Scanner;

public class Lab2 {
  static int count = 0;
  static int countP = 0;

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
    Double[] array = randomArray(Integer.parseInt(getAnswer()));
    Double[] a = array.clone();
    Double[] b = array.clone();

    /*selection(array);
    System.out.println("Selection " + count);
    System.out.println("Selection " + countP);*/

    // countP = 0;
    // count = 0;
    // insertion(a);
    // System.out.println("Insertion " + count);
    // System.out.println("Instertion " + countP);

    countP = 0;
    count = 0;
    cocktailSort(b);
    System.out.println("Shaker " + count);
    System.out.println("Shaker " + countP);

    /*countP = 0;
    count = 0;
    heap(c);
    System.out.println("Heap " + count);
    System.out.println("Heap " + countP);*/

    /*countP = 0;
    count = 0;
    sort(d, 0, d.length - 1);
    System.out.println("Fast " + count);
    System.out.println("Fast " + countP);*/
  }

  private static void sout(Double[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.println(a[i]);
    }
  }

  private static boolean less(Double v, Double w) {
    countP++;
    return v.compareTo(w) < 0;
  }

  private static void exch(Double[] a, int i, int j) {
    Double t = a[i];
    a[i] = a[j];
    a[j] = t;
    count++;
  }

  public static void selection(Double[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      int min = i;
      for (int j = i + 1; j < N; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
    // sout(a);
  }

  public static void insertion(Double[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) {
      countP++;
      for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
    }
    // sout(a);
  }

  public static void cocktailSort(Double[] a) {
    boolean swapped = true;
    int start = 0;
    int end = a.length;

    while (swapped) {
      swapped = false;
      for (int i = start; i < end - 1; ++i) {
        countP++;
        if (a[i] > a[i + 1]) {
          exch(a, i, i + 1);
          swapped = true;
        }
      }
      if (swapped == false) {
        countP++;
        break;
      }
      swapped = false;
      end = end - 1;
      for (int i = end - 1; i >= start; i--) {
        countP++;
        if (a[i] > a[i + 1]) {
          exch(a, i, i + 1);
          swapped = true;
        }
      }
      start = start + 1;
    }
    // sout(a);
  }

  public static void heap(Double[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i >= 0; i--) {
      exch(arr, 0, i);
      heapify(arr, i, 0);
    }
    // sout(arr);
  }

  public static void heapify(Double[] arr, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest]) {
      countP++;
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
      countP++;
      largest = r;
    }
    if (largest != i) {
      exch(arr, i, largest);
      heapify(arr, n, largest);
    }
  }

  private static void sort(Double[] a, int lo, int hi) {
    if (hi <= lo) return;
    int lt = lo, gt = hi;
    Double v = a[lo];
    int i = lo + 1;
    while (i <= gt) {
      int cmp = a[i].compareTo(v);
      countP++;
      if (cmp < 0) {
        exch(a, lt++, i++);
      } else if (cmp > 0) {
        exch(a, i, gt--);
      } else i++;
    }

    // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
    assert isSorted(a, lo, hi);
  }

  private static boolean isSorted(Double[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
      if (less(a[i], a[i - 1])) {
        return false;
      }
    return true;
  }
}
