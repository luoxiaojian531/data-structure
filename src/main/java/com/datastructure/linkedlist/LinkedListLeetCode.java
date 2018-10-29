package com.datastructure.linkedlist;

/**
 * 1、单链表的反转
 * 2、链表中环的检测
 * 3、两个有序的链表集合
 * 4、删除链表倒数第n个结点
 * 5、求链表的中间结点
 *
 * Created by lx on 2018/10/19.
 */
public class LinkedListLeetCode {

    /**
     * 单链表的反转（递归算法）
     * @param node
     * @return
     */
    public static Node recursionReverseLinkedList(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node head = recursionReverseLinkedList(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return head;
    }

    /**
     * 单链表的反转（迭代算法）
     * @param node
     * @return
     */
    public static Node iterateReverseLinkedList(Node node) {
        Node prevNode = null;
        Node currentNode = node;
        Node head = null;
        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            if (nextNode == null) {
                head = currentNode;
            }
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return head;
    }

    /**
     * 检测环
     * @param node
     * @return
     */
    public static boolean checkCircle(Node node) {
        if (node == null) {
            return false;
        }
        Node fastNode = node.getNext();
        Node slowNode = node;
        while (fastNode != null && fastNode.getNext() != null) {
            fastNode = fastNode.getNext().getNext();
            slowNode = slowNode.getNext();
            if (slowNode == fastNode) {
                return true;
            }
        }
        return false;
    }

    /**
     * 有序链表合并
     * @param la 有序链表la
     * @param lb 有序链表lb
     * @return
     */
    public static Node mergeSortedLinkedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        Node head;
        if (la.getData() < lb.getData()) {
            head = la;
            la = la.getNext();
        } else {
            head = lb;
            lb = lb.getNext();
        }
        while (la != null && lb != null) {
            if (la.getData() < lb.getData()) {
                head.setNext(la);
                la = la.getNext();
            } else {
                head.setNext(lb);
                lb = lb.getNext();
            }
            head = head.getNext();
        }
        if (la != null) {
            head.setNext(la);
        } else {
            head.setNext(lb);
        }
        return head;
    }

    /**
     * 删除倒数第n个节点
     * @param node 链表结点
     * @param n 删除结点倒数的位置
     * @return
     */
    public static Node deleteLastNode(Node node, int n) {
        if (node == null) {
            return null;
        }
        int i = 1;
        while (node != null) {
            node = node.getNext();
            ++i;
        }
        if (i < n) {
            return null;
        }
        int index = i - n;
        if (index == 0) {
            node = node.getNext();
            return node;
        }
        int j = 0;
        Node q = null;
        while (node != null) {
            if (index == j + 1) {
                q = node;
                break;
            }
            node = node.getNext();
            ++j;
        }
        if (q == null) {
            return q;
        }
        Node resultNode = q.getNext();
        q.setNext(q.getNext().getNext());
        return resultNode;
    }

    /**
     * 求链表的中间结点
     * @param node
     * @return
     */
    public static Node findMiddleNode(Node node) {
        if (node == null) {
            return null;
        }
        Node fast = node;
        Node slow = node;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        return slow;
    }

}