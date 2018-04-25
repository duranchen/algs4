import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {

    private class Node
    {
        Item item;
        Node next;
    }

    private int n;
    private Node head;
    public Bag(){
        n=0;
        head =null;
    }
    public void add(Item item)
    {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next =head;

        head = newNode;
        n++;

    }
    public boolean isEmpty()
    {
        return n==0;
    }

    public int size()
    {
        return n;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node p = head;

        public ListIterator() {

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
        Bag<Integer> b = new Bag<Integer>();
        for (int i = 0; i < 10; i++) {
            b.add(i);
        }

        for (int i : b
                ) {
            StdOut.println(i);
        }
        StdOut.println("Bad Size: "+b.size());
    }

}
