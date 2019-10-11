package com.test;

public class Test {
    public static void main(String[] args) {
        System.out.println(a(3));//5
        System.out.println(b(3));//3
    }

    /**
     * 执行步骤:
     * 1，传入3：递归调用a(2)+a(1)
     * //执行a(2)============求值
     * 2，a(2)递归调用a(1)+a(0)
     * 3,a(1)递归调用a(0)+a(-1)====a(0)==1,a(-1)==1
     * a(0)===1
     * 求值结果:3
     * //执行a(1)===========求值
     * 4， 递归调用a(0)+a(-1)====a(0)==1,a(-1)==1
     * 求值结果:2
     * 总体结果:==================3+2=5
     *
     * @param b
     * @return
     */
    public static int a(int b) {

        if (b <= 0) return 1;

        else {

            return a(b - 1) + a(b - 2);
        }

    }

    public static int b(int b) {

        if (b <= 0) return 1;

        else {

            return b(b - 1);
        }

    }
}
