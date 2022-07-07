package com.ocp;


public class ObjectInit {
    public static void main(String args[]) {
        ObjectInit obj = new ObjectInit(5);
    }
    int m;
    static int i1 = 5;
    static int i2;
    int j = 100;
    int x;

    public ObjectInit(int m) {
        System.out.println(i1 + "  " + i2 + "   " + x + "  " + j + "  " + m);
    }

    {
        j = 30;
        i2 = 40;
    }  // Instance Initializer

    static {
        i1++;
    }      // Static Initializer
}
