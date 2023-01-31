package MRA.DSA;

public class DoublyCacheLinkedList{
    public CacheNode head = new CacheNode();
    public CacheNode tail = new CacheNode();

    public DoublyCacheLinkedList(){
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty(){
        return (head.next == tail && tail.prev == head);
    }

    public void add(CacheNode node){
        CacheNode head_next = head.next;

        node.next = head_next;
        head_next.prev = node;

        node.prev = head;
        head.next = node;
    }

    public void remove(CacheNode node){
        CacheNode node_next = node.next;
        CacheNode node_prev = node.prev;

        node_next.prev = node_prev;
        node_prev.next = node_next;
    }

    public void display(){
        CacheNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
            if(temp.next!=null){
                System.out.print(temp.val+" ");
            }
        }
        System.out.println();
    }
}
