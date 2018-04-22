import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class FixedCapacityStack<Item>  implements Iterable<Item> {

    private Item[] stack;
    private int N;

    public FixedCapacityStack (int capacity)
    {
        stack = (Item[]) new Object[capacity];
        N = 0;

    }
    public Item pop()
    {
        return stack[--N];
    }

    public void push(Item item)
    {
        stack[N++] = item;
    }

    public boolean isEmpty()
    {
        return N==0;
    }

    public int size()
    {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>
    {
        int i = N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args)
    {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(5);
        stack.push(5);
        stack.push(4);
        stack.push(10);
        stack.pop();

        for (Integer i: stack
             ){
            StdOut.println(i);
        }

    }
}
