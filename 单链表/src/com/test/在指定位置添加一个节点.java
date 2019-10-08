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
