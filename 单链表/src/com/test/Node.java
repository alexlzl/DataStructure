package com.test;

public class Node {
    //节点的值
    int value;
    //指向下一个节点的指针（java 中表现为下一个节点的引用）
    Node next;

    public  Node(int value) {
        this.value = value;
    }
}
