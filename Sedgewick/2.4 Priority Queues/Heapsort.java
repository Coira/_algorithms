public class Heapsort {
    public static void sort(Comparalbe[] a) {
        int N = a.length;

        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }
}
