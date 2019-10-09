package com.test;

/**
 * 首先此题也是也是考察快慢指针的一个题，也是快慢指针的第二个应用。
 * 先简单说一下什么循环链表，循环链表其实就是单链表的尾部指针指向头指针，构建成一个环形的链表，叫做循环链表。
 * 如 1 -> 2 - > 3 -> 1 -> 2 .....。
 * 为什么快慢指针再循环链表中总能相遇呢？你可以想象两个人在赛跑，A的速度快，B的速度慢，经过一定时间后，A总是会和B相遇，
 * 且相遇时A跑过的总距离减去B跑过的总距离一定是圈长的n倍。这也就是 Floyd判环(圈)算法。
 */
public class 判断一个链表是否是循环链表 {
    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        Node next3 = new Node(3);
        head.next = next1;
        next1.next = next2;
        next2.next=next3;
        next3.next=head;
        System.out.println(isLoopList(head));
    }
    private static boolean isLoopList(Node head) {

        if (head == null) {
            return false;
        }


        Node slow = head;
        Node fast = head.next;

        //如果不是循环链表那么一定有尾部节点 此节点 node.next = null
        while (slow != null && fast != null && fast.next != null) {
            if (fast == slow || fast.next == slow) {
                return true;
            }
            // fast 每次走两步  slow 每次走一步
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果不是循环链表返回 false
        return false;
    }


}
