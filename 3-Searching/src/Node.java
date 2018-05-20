public class Node<Key,Value> {
    public Key key;
    public Value value;
    public Node next;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}