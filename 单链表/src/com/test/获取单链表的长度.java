package com.test;

/**
 * 由于单链表的存储地址不是连续的，链表并不具有直接获取链表长度的功能，
 * 对于一个链表的长度我们只能一次去遍历链表的节点，直到找到某个节点的下一个节点为空的时候得到链表的总长度，
 * 注意这里的出发点并不是一个空链表然后依次添加节点后，然后去读取已经记录的节点个数，而是已知一个链表的头结点然后去获取这个链表的长度：
 */
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
