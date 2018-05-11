public class LinkedListWithDummyHead<Item> {
    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private int N;
    private Node dummyHead;

    public LinkedListWithDummyHead() {
        dummyHead = new Node(null, null);
        N = 0;

    }

    public void addFirst(Item item) {
       add(0,item);
    }

    public void add(int index, Item item) {

        if (index < 0 || index > N) {
            throw new IllegalArgumentException("Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(item);
        newNode.next = prev.next;
        prev.next = newNode;

        N++;

    }


    public void addLast(Item item) {
        add(N, item);
    }


    public Item get(int index)
    {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException("Illegal index.");
        }
        Node current = dummyHead.next;

        for (int i= 0; i <index ; i++) {
            current = current.next;
        }

        return current.item;
    }

    public Item getFirst()
    {
        return get(0);
    }

    public Item getLast()
    {
        return get(N-1);
    }

    public void set(int index,Item item)
    {
        if (index < 0 || index > N) {
            throw new IllegalArgumentException("Illegal index.");
        }
        Node current = dummyHead.next;

        for (int i= 0; i <index ; i++) {
            current = current.next;
        }

        current.item = item;
    }

    public boolean contains(Item item)
    {
        Node current = dummyHead.next;
        while(current != null)
        {
            if(current.item.equals(item))
            {
                return true;
            }

            current = current.next;
        }
        return false;
    }

    public Item remove(int index)
    {
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node removeNode = prev.next;
        prev.next = removeNode.next;

        removeNode.next =null;

        N--;

        return removeNode.item;
    }

    public void removeRecursion(int index)
    {
        Node head = dummyHead.next;

        dummyHead.next = remove(head, index, 0);


    }

    public Node remove(Node head, int index, int count)
    {
        if(head == null)
        {
            return null;
        } else {
            Node result = remove(head.next,index,count+1);
            if(count == index)
            {
                return result;
            } else {

                head.next = result;

                return head;
            }
        }
    }

    public Item removeFirst()
    {
        return remove(1);
    }

    public Item removeLast()
    {
        return remove(N-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Linked List with DummyHead Size: %d\n", N));
        sb.append("{");
        for (Node current = dummyHead.next; current != null; current = current.next) {

            sb.append(current.item);
            if (current.next != null) {
                sb.append("->");
            }
        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedListWithDummyHead<Integer> ll = new LinkedListWithDummyHead<>();

        for (int i = 0; i < 5; i++) {
            ll.addFirst(i);
        }


        System.out.println(ll);

        ll.removeRecursion(1);
        System.out.println(ll);
    }
}
