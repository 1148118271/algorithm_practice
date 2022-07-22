package org.gxk;

import java.util.Iterator;

/**
 * 栈数据结构实现
 * @param <I>
 */
public class CapacityStack<I> implements Iterable<I> {

    int N = 0;

    I[] a = (I[]) new Object[8];

    private CapacityStack(){}

    public void put(I v) {
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = v;
    }

    public I remove() {
        I i = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return i;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int max) {
        I[] n = (I[]) new Object[max];
        if (N > 0) {
            System.arraycopy(a, 0, n, 0, N);
        }
        a = n;
    }

    @Override
    public Iterator<I> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<I> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public I next() {
            return a[--i];
        }
    }



    public static void main(String[] args) {
		CapacityStack<String> f = new CapacityStack<>();
		f.put("sds");
		f.put("sdasd");
		f.put("的吗");
		f.put("阿斯顿撒啊");

		for (String s : f) {
			System.out.println(s);
		}
    }
}
