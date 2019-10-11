package com.test;

/**
 * 　对于递归函数的使用，人们所关心的一个问题是栈空间的增长。确实，随着被调用次数的增加，
 * 某些种类的递归函数会线性地增加栈空间的使用 —— 不过，有一类函数，即尾部递归函数，不管递归有多深，栈的大小都保持不变。尾递归属于线性递归，更准确的说是线性递归的子集。
 * * 　　函数所做的最后一件事情是一个函数调用（递归的或者非递归的），这被称为 尾部调用（tail-call）。
 * 使用尾部调用的递归称为 尾部递归。当编译器检测到一个函数调用是尾递归的时候，它就覆盖当前的活动记录而不是在栈中去创建一个新的。
 * 编译器可以做到这点，因为递归调用是当前活跃期内最后一条待执行的语句，于是当这个调用返回时栈帧中并没有其他事情可做，因此也就没有保存栈帧的必要了。
 * 通过覆盖当前的栈帧而不是在其之上重新添加一个，这样所使用的栈空间就大大缩减了，这使得实际的运行效率会变得更高。
 * 　　让我们来看一些尾部调用和非尾部调用函数示例，以了解尾部调用的含义到底是什么：
 */
public class 尾部调用 {
    int test1() {
        int a = 3;
        test1(); /* recursive, but not a tail call.  We continue */
        /* processing in the function after it returns. */
        a = a + 4;
        return a;
    }

    int test2() {
        int q = 4;
        q = q + 5;
        return q + test1(); /* test1() is not in tail position.
         * There is still more work to be
         * done after test1() returns (like
         * adding q to the result*/
    }

    int test3() {
        int b = 5;
        b = b + 2;
        return test1();  /* This is a tail-call.  The return value
         * of test1() is used as the return value
         * for this function.*/
    }

    int test4() {
        test3(); /* not in tail position */
        test3(); /* not in tail position */
        return test3(); /* in tail position */
    }
}
