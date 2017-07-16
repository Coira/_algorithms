public class Heapsort {
    private static void exch(Comparable[] a, int i, int j) {
        i--; j--;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        i--; j--;
        return a[i].compareTo(a[j]) < 0;
    }
    
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.print();
    }
    
    public static void main(String[] args) {
        String[] a = "25138".split("");
        sort(a);
        show(a);
    }
}
