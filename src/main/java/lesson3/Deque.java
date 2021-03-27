package lesson3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int n;

    public Deque() {
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(T item) {
        if (item == null) throw new NullPointerException("input must be not null");
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (last == null) last = first;
        else first.next.prev = first;
        n++;
    }

    public void addLast(T item) {
        if (item == null) throw new NullPointerException("input must be not null");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (first == null) first = last;
        else last.prev.next = last;
        n++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        T item = first.item;
        n--;
        if (isEmpty()) {
            last = null;
            first = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        T item = last.item;
        n--;
        if (isEmpty()) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node {

        private T item;
        private Node next;
        private Node prev;
    }
    private class ListIterator implements Iterator<T> {

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

    }
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.removeLast();
        System.out.println(deque.isEmpty());
        for (int i = 0; i < 100; i++) {
            deque.addFirst(i);
            deque.addLast(i * 10);
        }
        while (!deque.isEmpty()){
            System.out.println(deque.removeFirst());
        }
    }
}