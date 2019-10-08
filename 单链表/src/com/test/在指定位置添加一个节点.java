package com.test;

public class 在指定位置添加一个节点 {
    public static void main(String[] strings) {
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        head.next = next1;
        next1.next = next2;
        try {
            System.out.println("插入前" + head.next.value);
            insertElement(head, 100, 1);
            System.out.println("插入后" + head.next.value);
        } catch (Exception e) {


        }
    }

    // 注意这里 index 从 0 开始
    public static Node insertElement(Node head, int value, int index) throws Exception {
        //为了方便这里我们假设知道链表的长度
        int length = 获取单链表的长度.getLength(head);
        if (index < 0 || index >= length) {
            throw new Exception("角标越界！");
        }

        if (index == 0) {
            /**
             * 头插法
             */
            return addAtHead(head, value);
        } else if (index == length - 1) {
            /**
             * 尾插法
             */
            addAtTail(head, value);
        } else {
            /**
             * 随机插入法
             *
             * 在指定位置添加一个节点，首先我们应该找到这个索引所在的节点的前一个，以及该节点，分别记录这两个节点，
             * 然后将索引所在节点的前一个节点的 next 指针指向新节点，然后将新节点的 next 指针指向插入节点即可。
             * 与其他元素并没有什么关系，所以单链表插入一个节点时间复杂度为 O(1)，
             * 而数组插入元素就不一样了如果将一个元素插入数组的指定索引位置，
             * 那么该索引位置以后元素的索引位置(内存地址)都将发生变化，
             * 所以一个数组的插入一个元素的时间复杂度为 O(n);所以链表相对于数组插入的效率要高一些，删除同理。
             *
             *
             */
            Node pre = head;
            Node cur = head.next;
            //
            while (pre != null && index > 1) {
                pre = pre.next;
                cur = cur.next;
                index--;
            }

            //循环结束后 pre 保存的是索引的上一个节点 而 cur 保存的是索引值当前的节点
            Node node = new Node(value);
            pre.next = node;
            node.next = cur;
        }
        return head;
    }

    public static Node addAtHead(Node head, int value) {
        Node newHead = new Node(value);
        newHead.next = head;
        return newHead;
    }

    public static void addAtTail(Node head, int value) {
        Node node = new Node(value);
        Node dummyHead = head;

        //找到未节点 注意这里是当元素的下一个元素为空的时候这个节点即为未节点
        while (dummyHead.next != null) {
            dummyHead = dummyHead.next;
        }

        dummyHead.next = node;
    }

}
