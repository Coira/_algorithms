/* 
   Priority-queue client.
   Given an int M from the command line and an input 
   stream where each line contains a transaction, print
   M lines whose numbers are the highest.
*/

public class TopM {
    public static void main(String[] args) {
        // Print the top M lines in the input stream.
        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1);
        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ.
            pq.insert(new Transaction(StdIn.readLine()));
            if (pq.size() > M)
                pq.delMin();   // Remove min if M+1 entries on the PQ
        }  // Top M entries are on the PQ.

        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) StdOut.println(t);
    }
}
