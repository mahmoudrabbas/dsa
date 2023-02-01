package MRA.DSA;

import java.util.HashMap;
import java.util.Map;

public class MFUCache {
    int capacity;
    Map<Integer, Node> cache;
    DLL list;

    public MFUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        list = new DLL();
    }

    public int get(int key){
        int val = -1;
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            val = node.value;
            list.remove(node);
            list.add(node);
        }
        return val;
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            list.remove(node);
            node.value = value;
            list.add(node);
        }else{
            if (cache.size() == capacity){
                cache.remove(list.head.next.key);
                list.remove(list.head.next);
            }
            Node node = new Node(key, value);
            list.add(node);
            cache.put(key, node);
        }
    }
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(){}
        public Node(int key, int val){
            this.key = key;
            this.value = val;
        }

    }
    class DLL {
        Node head = new Node();
        Node tail = new Node();

        public DLL(){
            head.next = tail;
            tail.prev = head;
        }

        public void add(Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

}





