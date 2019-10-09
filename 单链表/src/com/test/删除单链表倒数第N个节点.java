package com.test;

/**
 * 看到这个题时候乐了，这考察的知识点不就是一道求解倒数第 n 个节点的进化版么。但是我们也说过，如果想操作链表的某个节点(添加，删除)还必须知道这个节点的前一个节点。所以我们删除倒数第 n 个元素就要找到倒数第 n + 1 个元素。然后将倒数第 n + 1个元素 p 的 next 指针 p.next  指向 p.next.next 。
 * 我们找到倒数第 n 个节点的时候，先让 fast 先走了 n-1 步，那么我们删除倒数第 n 个节点的时候就需要 让 fast 先走 n 步，构建一个 n+1 大小的窗口，然后 fast 和 slow 整体平移到链表尾部，slow 指向的节点就是 倒数第 n+1 个节点。
 * 这里我们还可以使用滑动窗口的思想来考虑临界值：
 * <p>
 * <p>
 * n = 1 的时候我们需要构建的窗口为 2,也就是当 fast.next = null 的时候 slow 在的倒数第二个节点上，那么可想而知是满足我们的条件的。
 * <p>
 * <p>
 * 当 1 < n < len 的时候我们总是能构建出这样的一个 len + 1大小的窗口，n 最大为 len -1 的时候，slow 位于头节点，fast 位于未节点，删除倒数第 n 个元素，即删除正数第二个节点，slow.next = slow.next.next 即可。
 * <p>
 * <p>
 * 当 n > len 的时候可想而知，我们要找的倒数第 n 个元素不存在，此时返回 头节点就好了
 * <p>
 * <p>
 * n = len 的时候比较特殊，循环并没有因为倒数第 len 个元素不存在而终止，并进行了 fast = fast.next; 循环结束后 fast 指向 null , 且此时 slow 位于头节点，所以我们要删除的节点是头节点，只需要在循环结束后判断 如果 fast == null 返回  head.next 即可
 */
public class 删除单链表倒数第N个节点 {
    /**
     * 删除倒是第 n 个节点 我们就要找到倒数第 n + 1 个节点， 如果 n > len 则返回原列表
     */
    private Node deleteLastNNode(Node head, int n) {

        if (head == null || n < 1) {
            return head;
        }

        Node fast = head;

        //注意 我们要构建长度为 n + 1 的窗口 所以 i 从 0 开始
        for (int i = 0; i < n; i++) {
            //fast 指针指向倒数第一个节点的时候，就是要删除头节点
            if (fast == null) {
                return head;
            } else {
                fast = fast.next;
            }
        }

        // 由于 n = len 再循环内部没有判断直接前进了一个节点，临界值 n = len 的时候 循环完成或 fast = null
        if (fast == null) {
            return head.next;
        }

        //此时 n 一定是小于 len 的 且 fast 先走了 n 步
        Node pre = head;

        while (fast.next != null) {
            fast = fast.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return head;
    }

}
