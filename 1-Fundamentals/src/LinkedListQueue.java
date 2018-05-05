import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<Item> implements Iterable<Item>,Queue<Item> {

    private class Node {
        private Item item;
        private Node next;
    }

    private int n;

    private Node first;
    private Node last;

    public LinkedListQueue() {
        first = null;
        last = null;
        n = 0;
    }

    public void enqueue(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;


        if (isEmpty()) {
            first = newNode;
            last = newNode;

        } else {
            last.next = newNode;
            last = newNode;
        }
        n++;

    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedListQueue is Empty");
        }
        Item item = first.item;
        first = first.next;

        if(isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    public Item peek()
    {
        return first.item;
    }

    public int size() {
        return n;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<Item> {

        private Node p = first;

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
        LinkedListQueue<Integer> q = new LinkedListQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }

        q.dequeue();
        for (int i : q
                ) {
            StdOut.println(i);
        }
        StdOut.println("LinkedListQueue Size: "+q.size());
    }

}
