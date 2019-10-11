package com.test;

public class TestBinaryTree {
    public static void main(String[] args) {
        testCreate();
    }

    /**
     * 构建树
     */
    public static void testCreate() {
        BinaryTree node = new BinaryTree("a");

        System.out.println("【node data】:" + node.getData());
        System.out.println("【node left data】:" + (node.left == null ? "null" : node.left.getData()));
        System.out.println("【node right data】:" + (node.right == null ? "null" : node.right.getData()));
    }


}
