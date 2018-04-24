import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int head, tail;
    private int N;

    public ResizingArrayQueue() {
        queue = (Item[]) new Object[2];
        head = 0;
        tail = 0;
        N = 0;
    }

    public void enqueue(Item item) {

        if (isFull()) {
            resize(2 * queue.length);
        }

        queue[tail++] = item;


        if (tail == queue.length) {
            tail = 0;
        }
        N++;
    }

    public Item dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        Item item = queue[head];
        queue[head] = null;
        head++;
        N--;

        if (head == queue.length) {
            head = 0;
        }

        if (N > 0 && N < queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;

    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean isFull() {
        return N == queue.length;
    }

    private void resize(int max) {

        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i <= N; i++) {
            temp[i] = queue[(head + i) % queue.length];
        }
        queue = temp;

        head = 0;
        tail = N;

    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            int p = (head + i) % queue.length;
            i++;
            return queue[p];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<Integer> q = new ResizingArrayQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();

        for (int i: q
             ) {
            StdOut.println(i);
        }
    }
}
