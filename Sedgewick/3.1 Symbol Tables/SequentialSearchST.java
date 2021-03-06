/*
  Symbol table using linked lists and sequential search.
*/

public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // TODO  -- see exercises
    // size()
    // keys()
    // delete()

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.val; // search hit
		}
        return null;      // search miss
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;   // search hit
                return;
            }
		}
        first = new Node(key, val, first); // search miss
    }
}


            
