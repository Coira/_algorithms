/* Stub for the method Select */

public static Comparable select(Comparable[] a, int k) {
    StdRandom.shuffle(a);
    int lo = 0, hi = a.length - 1;

    while (hi > lo) {
        int j = partition(a, lo, hi);
        if      (j == k) return a[k];
        else if (j > k) hi = j - 1;
        else if (j < k) lo = j + 1;
    }

    return a[k];
}
