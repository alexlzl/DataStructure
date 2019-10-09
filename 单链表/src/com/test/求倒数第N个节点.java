package com.test;

/**
 * 为什么这个题要放在快慢指针的后边呢，因为这个题的解题思想和快慢指针相似，我们可以想一下：如果我们让快指针先走 n-1 步后，然后让慢指针出发。快慢指针每次都只移动一个位置，当快指针移动到链表末尾的时候，慢指针是否就正处于倒数第 N 个节点的位置呢。
 * 是这里把这两个指针称之为快慢指针是不正确的，因为快慢指针是指一个指针移动的快一个指针移动的慢，而此题中 快指针只是比慢指针先移动了 n-1 个位置而已，移动速度是相同的。
 * 如果上边的讲解不好理解，这里提供另外一种思路，就是想象一下，上述快慢指针的移动过程，是否就相当于一个固定窗口大小为 n 的滑动窗口：
 * <p>
 * n = 1 fast 指针不移动 fast 到达最后一个节点 即 fast.next 的时候 slow 也到达尾部节点满条件
 * n = len fast 指针移动 n-1（len -1 ） 次 fast 到达最后一个节点  slow 位于头节点不变 满足条件 两个临界值均满足我们这种假设。
 * 1< n < len 的时候我们假设 n = 2 ，那么 fast 比 slow 先移动一步,也就是窗口大小为 2， 那么当 fast.next = null 即 fast 已经指向链表最后一个节点的时候，slow 就指向了 倒数第二个节点。
 */
public class 求倒数第N个节点 {
    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        Node next3 = new Node(3);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        System.out.println(getLastIndexNode(head, 2).value);
    }

    /**
     * 注意我们一般说倒数第 n 个元素 n 是从 1 开始的
     */
    private static Node getLastIndexNode(Node head, int n) {

        // 输入的链表不能为空，并且 n 大于0
        if (n < 1 || head == null) {
            return null;
        }

        // 指向头结点
        Node fast = head;
        // 倒数第k个结点与倒数第一个结点相隔 n-1 个位置
        // fast 先走 n-1 个位置
        for (int i = 1; i < n; i++) {
            // 说明还有结点
            if (fast.next != null) {
                fast = fast.next;
            } else {
                // 已经没有节点了，但是i还没有到达k-1说明n太大，链表中没有那么多的元素
                return null;
            }
        }

        Node slow = head;
        // fast 还没有走到链表的末尾，那么 fast 和 slow 一起走，
        // 当 fast 走到最后一个结点即，fast.next=null 时，slow 就是倒数第 n 个结点
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 返回结果
        return slow;
    }

}
