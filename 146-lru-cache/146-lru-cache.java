class LRUCache {
    class Node
    {
        Node next,prev;
        int key,val;
        Node(int k,int v)
        {
            key=k;
            val=v;
        }
    }
    Node head,tail;
    Map<Integer,Node>m;
    int cap;
    public LRUCache(int capacity) {
       head=new Node(0,0);
        tail=new Node(0,0);
        m=new HashMap<>();
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {//if we get something,means it has been used,so it is the most recently used,and thus moved to front
       if(m.containsKey(key))
       {
           Node x=m.get(key);
           delete(x);
           addToHead(x);
           return x.val;
       }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
      if(m.containsKey(key))
      {
        delete(m.get(key));  
      }
        if(m.size()==cap)
            delete(tail.prev);
        addToHead(new Node(key,value));
    }
    public void delete(Node node)//using dll because it easies implementing delete & addtoHead
    {
        m.remove(node.key);
        node.next.prev=node.prev;
        node.prev.next=node.next;
       
    }
    public void addToHead(Node node)
    {
        m.put(node.key,node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */