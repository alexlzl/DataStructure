package com.test;

/**
 * 同学们可能看到这道面试题笑了，咋这么简单，拿起笔来就开始写，遍历整个链表，拿到链表的长度len，再次遍历链表那么位于 len/2 位置的元素就是链表的中间元素。
 * 那么更渐快的方法是什么呢？或者说时间复杂度更小的方法如何实现这次查找？这里引出一个很关键的概念就是 快慢指针法，这也是面试官想考察的。
 * 假如我们设置 两个指针 slow、fast 起始都指向单链表的头节点。其中 fast 的移动速度是 slow 的2倍。
 * 当 fast 指向末尾节点的时候，slow 正好就在中间了。想想一下是不是这样假设一个链表长度为 6 ，
 * slow 每次一个节点位置， fast 每次移动两个节点位置，那么当fast = 5的时候 slow = 2 正好移动到 2 的节点的位置。
 */
public class 寻找单链表的中间元素 {

    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        Node next3 = new Node(3);
        head.next = next1;
        next1.next = next2;
        next2.next=next3;
        System.out.println(getMid(head).value);
    }

    public static Node getMid(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // fast.next = null 表示 fast 是链表的尾节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
