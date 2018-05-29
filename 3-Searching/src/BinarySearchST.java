import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Key[] keys;
    private Value[] values;
    private static final int INIT_CAPCITY = 2;
    private int N;

    public BinarySearchST() {
        this(INIT_CAPCITY);
    }

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
        N = 0;
    }

    public void resize(int max) {
        Key[] keysTmp = (Key[]) new Comparable[max];
        Value[] valuesTmp = (Value[]) new Object[max];

        for (int i = 0; i < N; i++) {
            keysTmp[i] = keys[i];
            valuesTmp[i] = values[i];
        }

        keys = keysTmp;
        values = valuesTmp;

    }

    public int rank(Key key) {

        // solution 1:
//        for (int i = 0; i < N; i++) {
//            if (keys[i].compareTo(key) >= 0) {
//                return i;
//            }
//        }
//
//        return N;

        // solution 2:
/*        int lo = 0;
        int hi = N - 1;


        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);

            if (cmp > 0) {
                lo = mid + 1;
            } else if (cmp < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }

        }


        return lo;
        */

        int lo = 0;
        int hi = N - 1;
        return rank(key, lo, hi);
    }

    public int rank(Key key, int lo, int hi) {
        if (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0) {
                return mid;
            } else {
                if (cmp > 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
                return rank(key, lo, hi);
            }
        } else {
            return lo;
        }
    }


    @Override
    public void delete(Key key) {
        int p = rank(key);

        if (p < N && keys[p].equals(key)) {

            for (int i = p; i < N - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }

            keys[N - 1] = null;
            values[N - 1] = null;
            N--;

            if (N == keys.length / 4) {
                resize(keys.length / 2);
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void put(Key key, Value value) {
        int position = rank(key);
        if (contains(key)) {
            values[position] = value;
        } else {
            if (N == keys.length) {
                resize(keys.length * 2);
            }

            for (int i = N; i > position; i--) {
                keys[i] = keys[i - 1];
                values[i] = values[i - 1];
            }

            keys[position] = key;
            values[position] = value;
            N++;

        }

    }

    @Override
    public Value get(Key key) {

        int p = rank(key);

        if (p < N && keys[p].equals(key)) {
            return values[p];
        } else {
            return null;
        }

    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;

    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            sb.append(keys[i]);
            if (i != keys.length - 1) {
                sb.append("->");
            }
        }

        sb.append("\n");

        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
            if (i != values.length - 1) {
                sb.append("->");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        BinarySearchST<Character, Integer> bsst = new BinarySearchST<>();

        bsst.put('A', 2);
        bsst.put('C', 4);
        bsst.put('B', 1);
        bsst.put('C', 0);
        bsst.delete('B');
        bsst.delete('A');

        System.out.println(bsst.get('C'));
        System.out.print(bsst);
    }
}
