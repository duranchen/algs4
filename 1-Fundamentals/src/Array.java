import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Array<Item> {
    private Item[] data;
    private int n;

    public Array(int capacity) {
        data =(Item[]) new Object[capacity];
        n = 0;
    }

    public Array() {
        this(10);
    }

    public int size() {
        return n;
    }

    public int capacity() {
        return data.length;
    }

    /**
     * 添加元素到数组末尾
     *
     * @param item
     */
    public void addLast(Item item) {
        if (n >= data.length)
            throw new IllegalArgumentException("Array Overflow");
        data[n] = item;
        n++;
    }

    public void add(int index, Item item) {

        if(n == data.length)
            resize(2*data.length);

        int i = n;
        while (i != index) {
            data[i] = data[i - 1];
            i--;
        }

        data[i] = item;
        n++;
    }

    public void resize(int max)
    {
        Item[] temp =(Item[]) new Object[max];

        for(int i = 0 ; i<n;i++)
        {
            temp[i] = data[i];
        }

        data = temp;
    }

    public void addFirst(Item item) {
        add(0, item);
    }

    public Item get(int index) {
        if (index < 0 || index > n)
            throw new NoSuchElementException();
        return data[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > n)
            throw new NoSuchElementException();
        data[index] = item;
    }

    public boolean contains(Item item) {
        for (int i = 0; i < n; i++) {
            if (data[i].equals(item) )
                return true;

        }

        return false;
    }

    public int find(Item item) {
        for (int i = 0; i < n; i++) {
            if (data[i].equals(item))
                return i;

        }

        return -1;
    }

    public Item delete(int index) {
        if (index < 0 || index > data.length)
            throw new NoSuchElementException("Array overflow");

        if(n == data.length/4)
        {
            resize(data.length/2);
        }

        Item item = get(index);
        for (int i = index; i < n - 1; i++) {
            data[i] = data[i + 1];

        }
        data[n--] = null;

        return item;
    }

    public Item deleteFirst()
    {
        return delete(0);
    }

    public Item deleteLast()
    {
        return delete( n-1);
    }

    public void deleteElement(Item item)
    {
        int index  = find(item);
        if(index != -1)
            delete(index);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format("Array Size:%d, Capacity:%d\n", n, data.length));

        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(data[i]);
            if (i != n - 1)
                sb.append(',');
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        Array<Integer> a = new Array<>(10);

        for (int i = 0; i < 10; i++) {
            a.addLast(i);
        }

        a.add(1, 11);
        a.addFirst(-1);


        System.out.println(a);

        a.delete(9);

        for(int i = 0; i<7;i++)
        {
            a.delete(0);
        }
        System.out.println(a);
    }

}
