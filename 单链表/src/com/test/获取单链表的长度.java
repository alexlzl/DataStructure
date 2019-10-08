package com.test;

public class 获取单链表的长度 {
    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        head.next = next1;
        next1.next = next2;
        System.out.println(getLength(head));
    }

    public static int getLength(Node head) {

        if (head == null) {
            return 0;
        }

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
