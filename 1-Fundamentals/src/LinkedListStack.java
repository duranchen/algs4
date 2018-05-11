import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<Item> implements Iterable<Item>,Stack<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int n;

    public LinkedListStack() {
        first = null;
        n = 0;
    }

    public void push(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;

        first = newNode;
        n++;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stackunderflow");
        }
        Item item = first.item;
        first = first.next;
        n--;

        return item;
    }

    @Override
    public Item peek() {
        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
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

        LinkedListStack<Integer> s = new LinkedListStack<Integer>();

        for(int i =0 ;i< 10;i++)
        {
            s.push(i);
        }

        s.pop();

        for (int i : s
                ) {
            StdOut.println(i);
        }
    }
}
