import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {

    private class Node {
        private Item item;
        private Node next;
    }

    private int n;

    private Node head;
    private Node tail;

    public Queue() {
        head = null;
        tail = null;
        n = 0;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;


        if (isEmpty()) {
            head = newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        Item item = head.item;
        head = head.next;

        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(head);
    }

    private class ListIterator implements Iterator<Item> {

        private Node p = head;

        public ListIterator(Node head) {

        }


        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public Item next() {
            Item item = p.item;
            p = p.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }

        q.dequeue();
        for (int i : q
                ) {
            StdOut.println(i);
        }

    }

}
