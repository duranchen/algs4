import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>,Stack<Item> {

    private Item[] stack;
    private int N;

    public ResizingArrayStack() {
        stack = (Item[]) new Object[1];
        N = 0;

    }

    public Item pop() {

        if (N == stack.length / 4) {
            resize(stack.length / 2);
        }

        Item item = stack[--N];
        stack[N] = null;
        return item;
    }

    @Override
    public Item peek() {
        return stack[N-1];
    }

    public void push(Item item) {
        if (N == stack.length) {
            resize(2 * stack.length);

        }

        stack[N++] = item;
    }

    private void resize(int max) {
        Item[] copy = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            copy[i] = stack[i];
        }

        stack = copy;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stack[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(10);
        stack.pop();

        for (Integer i : stack
                ) {
            StdOut.println(i);
        }

    }
}
