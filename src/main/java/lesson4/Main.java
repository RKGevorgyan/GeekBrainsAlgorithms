package lesson4;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        queueDemo();

        stackDemo();

        iteratorDemo();
    }

    private static void iteratorDemo() {
        System.out.println("====Iterator Demo====");
        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ListIterator<Integer> li = ll.listiterator();
        //print with for and iterator
        for (Integer i : ll) {
            System.out.print(i + " ");
        }
        System.out.println();

        //print with while and remove items from 2
        while (li.hasNext()) {
            System.out.print(li.next() + " ");
            if (li.hasPrevious()) {
                li.remove();
            }
        }
        System.out.println();
        System.out.println(ll);

        ll.insertLast(10);
        ll.insertLast(20);

//print upside down
        li = ll.listiterator();
        while (li.hasPrevious()) {
            System.out.print("tyt");
//            if (li.previousIndex() == 1) {
//                li.add(7);
//            }
        }
        System.out.println(ll);
    }

    private static void queueDemo() {
        System.out.println("====LinkedQueue Demo====");
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        for (int i = 0; i < 11; i+=2) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        while (queue.size() != 0)
            System.out.print(queue.dequeue() + " : ");
        System.out.println();
        System.out.println("Queue: " + queue);
    }

    private static void stackDemo() {
        System.out.println("====LinkedStackDemo====");
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("Peek: " + stack.peek());
        try {
            for (int i = 0; i < 11; i++) {
                System.out.println(stack.pop() + ": " + stack);
            }
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
