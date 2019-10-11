package com.test;

public class 插入左节点 {
    /**
     * 测试插入结点
     */
    public static void testInsert() {
        BinaryTree node_a = new BinaryTree("a");
        node_a.insertLeft(node_a, "b");
        node_a.insertRight(node_a, "c");

        BinaryTree node_b = node_a.left;
        node_b.insertRight(node_b, "d");

        BinaryTree node_c = node_a.right;
        node_c.insertLeft(node_c, "e");
        node_c.insertRight(node_c, "f");

        BinaryTree node_d = node_b.right;
        BinaryTree node_e = node_c.left;
        BinaryTree node_f = node_c.right;

        System.out.println("【node_a data】:" + node_a.getData());
        System.out.println("【node_b data】:" + node_b.getData());
        System.out.println("【node_c data】:" + node_c.getData());
        System.out.println("【node_d data】:" + node_d.getData());
        System.out.println("【node_e data】:" + node_e.getData());
        System.out.println("【node_f data】:" + node_f.getData());
    }


}
