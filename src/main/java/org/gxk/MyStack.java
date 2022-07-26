package org.gxk;

import java.io.IOException;
import java.util.Iterator;
import java.util.Stack;

public class MyStack<I> implements Iterable<I> {
    public static void main(String[] args) throws IOException {
        MyStack<String> strings = new MyStack<>();

        strings.push("g");
        strings.push("x");
        strings.push("k");

        for (String string : strings) {
            System.out.println(string);
        }

        strings.pop();

        for (String string : strings) {
            System.out.println(string);
        }

    }


    private Node<I> first;

    private int N = 0;

    @Override
    public Iterator<I> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<I> {
        private int i = N;

        private Node<I> v = first;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public I next() {
            I item = v.i;
            v = v.next;
            --i;
            return item;
        }
    }

    private static class Node<I> {
        I i;
        Node<I> next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(I i) {
        Node<I> old = first;
        Node<I> t = new Node<>();
        t.i = i;
        t.next = old;
        first = t;
        ++N;
    }

    public I pop() {
        Node<I> v = first;
        first = first.next;
        --N;
        return v.i;
    }

}
