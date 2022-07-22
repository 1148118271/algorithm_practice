package org.gxk;

public class Node<I> {
    I i;
    Node<I> next;


    public static void main(String[] args) {
        Node<String> node1 = new Node<>();
        Node<String> node2 = new Node<>();
        Node<String> node3 = new Node<>();
        node1.i = "1";
        node2.i = "2";
        node3.i = "3";
        node1.next = node2;
        node2.next = node3;
    }
}
