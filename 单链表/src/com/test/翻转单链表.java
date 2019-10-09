package com.test;

/**
 * 翻转一个单链表，要求额外的空间复杂度为 O(1)
 * 翻转单链表是我感觉比较难的基础题，那么先来屡一下思路：一个节点包含指向下一节点的引用，翻转的意思就是对要原来指向下一个节点引用指向上一个节点
 * <p>
 * 找到当前要反转的节点的下一个节点并用变量保存因为下一次要反转的是它
 * 然后让当前节点的 next 指向上一个节点， 上一个节点初始 null 因为头结点的翻转后变为尾节点
 * 当前要反转的节点变成了下一个要比较元素的上一个节点，用变量保存
 * 当前要比较的节点赋值为之前保存的未翻转前的下一个节点
 * 当前反转的节点为 null 的时候，保存的上一个节点即翻转后的链表头结点
 * <p>
 * ok，不知道按照上边我写的步骤能否理解一个链表的翻转过程。如果不理解自己动手画一下可能更好理解哈，注意在画的时候一次只考虑一个节点，且不要考虑已经翻转完的链表部分。
 */
public class 翻转单链表 {
    public static void main(String[] args){
        Node node1=new Node("a");
        Node node2=new Node("b");
        Node node3=new Node("c");
        Node node4=new Node("d");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        System.out.println(node1.getData());
        System.out.println(node1.getNext().getData());
        System.out.println(node1.getNext().getNext().getData());
        System.out.println(node1.getNext().getNext().getNext().getData());
        reverseListNode(node1);
        System.out.println("反转后指向"+node4.getData());
        System.out.println("反转后指向"+node4.getNext().getData());
        System.out.println("反转后指向"+node4.getNext().getNext().getData());
        System.out.println("反转后指向"+node4.getNext().getNext().getNext().getData());

    }

    public static Node reverseListNode(Node head){
        //单链表为空或只有一个节点，直接返回原单链表
        if (head == null || head.getNext() == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode = null;

        while (curNode != null){
            nextNode = curNode.getNext();//nextNode 指向下一个节点
            curNode.setNext(preNode);//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }

        return preNode;
    }
    public static class Node {

        private Object data;//数据域
        private Node next;//指针域

        public Node(Object data){
            this.data = data;
        }

        public Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
