package com.test;

public class Test1 {
    public static void main(String[] args) {
        test();
    }

    private static int i;

    /**
     * 1
     * 2
     * 3
     * 4
     * 5
     * over===5
     * over===5
     * over===5
     * over===5
     * over===5
     */
    public static void test() {
        if (i == 5) {
            return;
        }
        i++;
        System.out.println(i);
        test();
        System.out.println("over===" + i);
    }
}
