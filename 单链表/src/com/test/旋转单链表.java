package com.test;

/**
 * 题目：给定一个链表，旋转链表，使得每个节点向右移动k个位置，其中k是一个非负数。 如给出链表为 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 做完，删除倒数第 n 个节点的题，我们在看着道题是不是很简单了，这道题的本质就是，找到 k 位置节点 将其变成尾节点，然后原来链表的尾节点指向原来的头节点
 */
public class 旋转单链表 {
    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        Node next3 = new Node(3);
        Node next4 = new Node(4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = next4;
        Node node = rotateList(head, 2);
        System.out.println(node.value);//2
        System.out.println(node.next.value);//3
        System.out.println(node.next.next.value);//4
        System.out.println(node.next.next.next.value);//0
        System.out.println(node.next.next.next.next.value);//1
    }

    private static Node rotateList(Node head, int n) {

        int start = 1;

        Node fast = head;

        //先让快指针走 n 个位置
        while (start < n && fast.next != null) {
            fast = fast.next;
            start++;
        }


        //循环结束后如果 start < n 表示 n 整个链表还要长 旋转后还是原链表
        //如果 fast.next = null 表示 n 正好等于原链表的长度此时也不需要旋转
        if (fast.next == null || start < n) {
            return head;
        }

        //倒数第 n + 1个节点
        Node pre = fast;
        //旋转后的头节点
        Node newHead = fast.next;

        while (fast.next != null) {
            fast = fast.next;
        }
        //原链表的最后一个节点指向原来的头节点
        fast.next = head;
        //将旋转的节点的上一个节点变为尾节点
        pre.next = null;

        return newHead;
    }


}
