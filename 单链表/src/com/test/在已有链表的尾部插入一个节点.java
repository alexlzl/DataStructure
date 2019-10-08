package com.test;

public class 在已有链表的尾部插入一个节点 {

    public static void main(String[] args){
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        head.next = next1;
        next1.next = next2;
        addAtTail(head,3);
        System.out.println(head.next.next.next.value);
    }
    public static void addAtTail(Node head, int value){
        Node node = new Node(value);
        Node dummyHead = head;

        //找到未节点 注意这里是当元素的下一个元素为空的时候这个节点即为未节点
        while( dummyHead.next != null){
            dummyHead = dummyHead.next;
        }

        dummyHead.next = node;
    }

}
