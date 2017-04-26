/* Sedgewick Chapter 1.5 Union Find */

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /* old, slow union */
    /*
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }
    
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        count--;
    }
    */

    /* quick-union */
    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        // put p and q into the same component
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        // change values from id[p] to id[q]
        for (int i = 0; i< id.length; i++) {
            if (id[i] == pID) { id[i] = qID; }
        }
        count--;
    }
        
    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }

        StdOut.println(uf.count() + " components");
    }
}
}
                
    
