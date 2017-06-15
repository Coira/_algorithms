/*
  Max value heap priority queue.
*/

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;   // pq[0] left unused
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N0);
    }

    public Key delMax() {
        Key max = pq[1];     // Retrieve max key from top
        exch(1, N--);        // Exch with last item.
        pq(N+1] = null;      // Avoid loitering.
        sink(1);             // Restore heap property.
    }

    // TODO fill these in
    private boolean less(int i, int j) {
    }

    private void exch(int i, int j) {
    }

    private void swim(int k) {
    }

    private void sink(int k) {
    }
}



    
    
