package com.datastructure.linkedlist;

/**
 * 双向链表
 * 1、int类型的双向链表
 * 2、双向链表的插入、删除、查询操作
 *
 * Created by lx on 2018/10/17.
 */
public class DoubleLinkedList {

    private Node head = null;

    public DoubleLinkedList(int value) {
        this.head = new Node(value, null);
    }

    /**
     * 根据结点数据找结点
     * @param value 节点数据
     * @return 结点
     */
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.getData() != value) {
            p = p.getNext();
        }
        return p;
    }

    /**
     * 根据指针索引找结点
     * @param index 索引
     * @return 结点
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.getNext();
            ++pos;
        }
        return p;
    }

    /**
     * 插入头结点
     * @param newNode 新节点
     */
    public void insertToHead(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
        }else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    /**
     * 在指定结点后插入新数据
     * @param p 指定结点
     * @param value 新结点数据
     */
    public void insertToAfter(Node p,int value) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(value, null);
        newNode.setNext(p.getNext());
        p.getNext().setPrev(newNode);
        p.setNext(newNode);
        newNode.setPrev(p);
    }

    /**
     * 在指定结点前插入新数据
     * @param p 指定结点
     * @param value 新节点数据
     */
    public void insertToBefore(Node p, int value) {
        if (p == null) {
            return;
        }
        Node newNode = new Node(value, null);
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        p.getPrev().setNext(newNode);
        newNode.setPrev(p.getPrev());
        newNode.setNext(p);
        p.setPrev(newNode);
    }

    /**
     * 删除结点
     * @param p 结点
     */
    public void deleteByNode(Node p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            head = head.getNext();
            return;
        }
        p.getNext().setPrev(p.getPrev());
        p.getPrev().setNext(p.getNext());
    }

    public void print() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
        System.out.println("");
    }
}
