import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node head;
    private int n;

    public Stack() {
        head = null;
        n = 0;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;

        head = newNode;
        n++;

    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stackunderflow");
        }
        Item item = head.item;
        head = head.next;
        n--;

        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
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

        Stack<Integer> s = new Stack();
        s.push(1);
        s.pop();
        s.push(2);
        for (int i : s
                ) {
            StdOut.println(i);
        }
    }
}
