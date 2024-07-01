class LRUCache 
{
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap();
    int capacity;
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }
        else
            return -1;
    }
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(map.size()==capacity)
        {
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    public void remove(Node n)
    {
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;              
    }
    public void insert(Node n)
    {
        map.put(n.key,n);
        Node headNext = head.next;
        head.next = n;
        n.prev = head;
        n.next = headNext;
        headNext.prev = n;
    }
}
class Node
{
    Node prev,next;
    int key;
    int value;
    Node(int key,int value)
    {
        this.key= key;
        this.value=value;
    }
}
