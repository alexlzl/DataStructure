package com.test;

/**
 * 给定一个单链表，把位于从m至n的元素翻转
 * <p>
 * 例如给定链表：1->2->3->4->5->null，m=2, n=4，则翻转后的链表为：1->4->3->2->5->null。
 */
public class 部分翻转 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode("a");
        ListNode listNode2 = new ListNode("b");
        ListNode listNode3 = new ListNode("c");
        ListNode listNode4 = new ListNode("d");
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        System.out.println(listNode1.data);
        System.out.println(listNode1.next.data);
        System.out.println(listNode1.next.next.data);
        System.out.println(listNode1.next.next.next.data);
        reverseBetween(listNode1,2,3);
        System.out.println("反转后"+listNode1.data);
        System.out.println("反转后"+listNode1.next.data);
        System.out.println("反转后"+listNode1.next.next.data);
        System.out.println("反转后"+listNode1.next.next.next.data);

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;
        int count = 1;
        ListNode pre = head.next;
        ListNode curr = head;
        ListNode latt = null;
        ListNode p1 = null;//标记翻转前的元素，用于链接到翻转后的第一个元素
        ListNode p2 = null;//标记翻转后的最后一个元素，用于链接到n后面的元素
        while (pre != null) {
            if (count == m) {//从第m个元素开始翻转
                p1 = latt;
                p2 = curr;
                for (; count < n; count++) {
                    latt = curr;
                    curr = pre;
                    pre = pre.next;
                    curr.next = latt;
                }
                if (p1 == null) {//m = 1, 从head开始翻转，p1为空，不需要把p1链接到翻转后的链表
                    p2.next = pre;
                    return curr;
                } else {//从中间开始翻转，两端重新链接
                    p2.next = pre;
                    p1.next = curr;
                    return head;
                }
            }
            latt = curr;//第m个元素之前的遍历
            curr = pre;
            pre = pre.next;
            count++;
        }
        return head;
    }

  static   class ListNode {

        ListNode next;
        String data;

        public ListNode(String data) {
            this.data = data;
        }
    }
}
