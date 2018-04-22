import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        //basic version - use exchange elements
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j > 0; j--) {
//                if (less(a[j], a[j - 1])) {
//                    exch(a, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }
        // advanced version - move elements no exchange
        for (int i = 1; i < N; i++) {
            T e = a[i];
            int j = i;
            for (; j > 0; j--) {
                if (less(e, a[j - 1])) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j] = e;
        }
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
