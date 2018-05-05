import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Loop Queue
public class ResizingArrayQueue<Item> implements Iterable<Item>, Queue<Item> {
    private Item[] queue;
    private int first;
    private int last;  // next available slot
    private int N;

    public ResizingArrayQueue() {
        queue = (Item[]) new Object[2];
        first = 0;
        last = 0;
        N = 0;
    }

    public void enqueue(Item item) {

        if (isFull()) {
            resize(2 * queue.length);
        }

        queue[last++] = item;

        if (last == queue.length) {
            last = 0;
        }
        N++;
    }

    public Item dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }

        Item item = queue[first];
        queue[first] = null;
        first++;
        N--;

        if (first == queue.length) {
            first = 0;
        }

        if (N > 0 && N < queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;

    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return queue[first];
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
            temp[i] = queue[(first + i) % queue.length];
        }
        queue = temp;

        first = 0;
        last = N;

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

            int p = (first + i) % queue.length;
            i++;
            return queue[p];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format("Queue Size:%d, Capacity:%d\n", N, queue.length));

        sb.append("first->[");
        for (int i = first; i != last; i = (i + 1) % queue.length) {
            sb.append(queue[i]);
            if (i != last - 1)
                sb.append(',');
        }
        sb.append("]<-last");

        return sb.toString();
    }


    public static void main(String[] args) {
        ResizingArrayQueue<Integer> q = new ResizingArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
        }


        System.out.println(q);

    }
}
