public interface Queue<Item> {


    public void enqueue(Item item);

    public Item dequeue();

    public int size();

    public Item peek();

    public Boolean isEmpty();
}
