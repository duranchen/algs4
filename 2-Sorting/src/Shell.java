import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {


    public static <T extends Comparable<T>> void sort(T[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (less(a[j], a[j - h])) {
                        exch(a, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }

    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    private static <T extends Comparable<T>> void show(T[] a) {
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
