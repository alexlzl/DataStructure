package com.test;

public class Recursion {
    public static void main(String args[]) {
        recursion(4267);
    }

    public static void recursion(int value) {
        int quotient;
        quotient = value / 10;
        if (quotient != 0) {
            recursion(quotient);
        }
        System.out.println(value % 10);
    }


}
