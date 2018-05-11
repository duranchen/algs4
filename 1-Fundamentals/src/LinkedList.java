// Linked list with first point
public class LinkedList<Item> {

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }


    }

    private int N;
    private Node first;

    public LinkedList() {
        first = null;
        N = 0;

    }

    public void addFirst(Item item) {
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        N++;
    }

    public void add(int index, Item item) {

        if (index < 0 || index > N) {
            throw new IllegalArgumentException("Illegal index.");
        }

        if (index == 0) {
            addFirst(item);
        } else {
            Node prev = first;
            for (int i = 1; i < index; i++) {
                prev = prev.next;
            }
            Node newNode = new Node(item);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        N++;

    }

   

    public void addLast(Item item) {
        add(N, item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Linked List Size: %d\n", N));
        sb.append("{");
        for (Node current = first; current != null; current = current.next) {

            sb.append(current.item);
            if (current.next != null) {
                sb.append("->");
            }
        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            ll.addFirst(i);
        }

        ll.add(1, -1);

        System.out.println(ll);
    }
}
