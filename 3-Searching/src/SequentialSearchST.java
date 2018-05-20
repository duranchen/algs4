import java.util.LinkedList;

public class SequentialSearchST<Key, Value> implements ST<Key,Value> {

    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    private Node first;
    private int N;

    public SequentialSearchST() {
        first = null;
        N = 0;
    }

    @Override
    public void put(Key key, Value value) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
        }

        Node node = new Node(key, value);

        node.next = first;
        first = node;
        N++;

    }

    public Value get(Key key) {
        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }

        return null;
    }

    public void delete(Key key) {

        if (first.key == key) {
            Node oldFirst = first;
            first = first.next;
            oldFirst = null;
            N--;
            return;
        }

        for (Node prev = first; prev.next != null; prev = prev.next) {
            if (prev.next.key == key) {
                Node delNode = prev.next;
                prev.next = prev.next.next;
                delNode = null;
                N--;
                return;
            }
        }
    }

    public void deleteRecursion(Key key) {
        first = delete(first, key);
    }

    public Node delete(Node first, Key key) {

        if (first == null) {
            return null;
        }

        if (first.key.equals(key)) {

            first = first.next;
            return first;

        }

        first.next = delete(first.next, key);

        return first;


    }

    public boolean contains(Key key) {

        for (Node current = first; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        LinkedList<Key> keyList = new LinkedList<>();
        for (Node current = first; current != null; current = current.next) {

            keyList.add(current.key);
        }

        return keyList;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node current = first; current != null; current = current.next) {
            sb.append(current.key);
            sb.append("|");
            sb.append(current.value);
            if (current.next != null) {
                sb.append("->");
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        SequentialSearchST<Character, Integer> st = new SequentialSearchST<>();
        String s = "SEARCHEXAMPLE";
        for (int i = 0; i < s.length(); i++) {
            st.put(s.charAt(i), i);
        }


        System.out.println(st);

        st.deleteRecursion('P');
        System.out.println(st);
        st.delete('L');
        System.out.println(st);
        System.out.println(st.get('E'));
        System.out.println(st.contains('R'));
        System.out.println(st.contains('Z'));
        System.out.println(st.isEmpty());
        System.out.println(st.size());
        LinkedList<Character> keys =  (LinkedList<Character>) st.keys();

        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i));

            if(i != keys.size()-1)
            {
                System.out.print("->");
            }
        }


//        for (Character key : keys) {
//            System.out.print(key+"->");
//
//        }
    }


}
