import edu.princeton.cs.algs4.*;

public class Selection {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 0; i<N; i++)
        {

            int min = i;
            for(int j = i+1; j<N;j++)
            {
                if(less())
            }
        }
    }

    public static  boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private static void show(Comparable[] a)
    {
        for(int i =0 ;i<a.length;i++)
        {
            StdOut.print(a[i]+" ");
        }
        StdOut.println();

    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private  static boolean isSorted(Comparable[] a)
    {
        for(int i=0; i<a.length-1;i++)
        {
            if(less(a[i+1],a[i]))
            {
                return false;
            }
        }
        return true;
    }
}
