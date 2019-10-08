package com.test;

public class 查询指定索引的节点值或指定值得节点值的索引 {
    public static void main(String[] args){
        Node head = new Node(0);
        Node next1 = new Node(1);
        Node next2 = new Node(2);
        head.next = next1;
        next1.next = next2;
        try {
            System.out.println(getValueOfIndex(head,2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取指定角标的节点值
     */
    public static  int getValueOfIndex(Node head, int index) throws Exception {

        if (index < 0 || index >= 获取单链表的长度.getLength(head)) {
            throw new Exception("角标越界！");
        }

        if (head == null) {
            throw new Exception("当前链表为空！");
        }

        Node dummyHead = head;

        while (dummyHead.next != null && index > 0) {
            dummyHead = dummyHead.next;
            index--;
        }

        return dummyHead.value;
    }


    /**
     * 获取节点值等于 value 的第一个元素角标
     */
    public static int getNodeIndex(Node head, int value) {

        int index = -1;
        Node dummyHead = head;

        while (dummyHead != null) {
            index++;
            if (dummyHead.value == value) {
                return index;
            }
            dummyHead = dummyHead.next;
        }

        return -1;
    }


}
