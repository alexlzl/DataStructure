package com.test;

public class Test2 {
    public static void main(String[] args){
       System.out.print( factorial(5));
    }
    public static int factorial(int N) {
        if (N == 1) return 1;
        return N * factorial(N-1);
    }
}
