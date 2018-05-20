public class BST<Item extends Comparable<Item>> {

    private class Node {
        Item item;
        Node left;
        Node right;

        public Node(Item item)
        {
            this.item = item;
            left = null;
            right = null;
        }
    }


    private int N;

    private Node root;


    public BST()
    {
        root = null;
        N =0;
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N ==0;
    }

    public void put(Item item)
    {
        root = put(root,item);
    }

    public Node put(Node root, Item item)
    {
        Node node = new Node(item);
        if(root == null) {
            root = node;
            N++;
            return root;

        } else {
            if( node.item.compareTo(root.item) < 0)
            {
                root.left = put(root.left, item);

            } else {
                root.right= put(root.right,item);
            }

            return root;
        }

    }

    public boolean get(Item item)
    {

        return  get(root,item);
    }

    public boolean get(Node node, Item item)
    {

        if(node == null)
        {
            return false;
        }
        if(node.item == item)
        {
            return true;
        } else {
            if(item.compareTo(node.item)<0)
            {
                return get(node.left, item);
            } else {
                return get(node.right,item);
            }
        }
    }

   public static void main(String[] args)
   {
       BST<Integer> bst = new BST<>();

       bst.put(2);
       bst.put(1);
       bst.put(3);

       System.out.println(bst.size());
       System.out.println(bst.get(5));
   }
}
