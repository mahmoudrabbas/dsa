package MRA.DSA;
import java.util.Map;
import java.util.HashMap;


public class LFU_Cache {
    int capacity;
    int minFreq;

    Map<Integer, Node> cache;
    Map<Integer, DLL> freq_map;

    public LFU_Cache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        cache = new HashMap<>();
        freq_map = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node==null){
            return -1;
        }else{
            update(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            update(node);
        }else{
            if(capacity == cache.size()){
                DLL list = freq_map.get(minFreq);
                cache.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
            }
            minFreq =1;
            Node newNode = new Node(key, value, 1);
            DLL curr_list = freq_map.getOrDefault(1, new DLL());
            curr_list.offer(newNode);
            freq_map.put(1, curr_list);
            cache.put(key, newNode);
        }
    }

    public void update(Node node){
        int curr_freq = node.frequency;
        DLL freq_list = freq_map.get(curr_freq);
        freq_list.remove(node);
        if(freq_list.isEmpty() && curr_freq == minFreq){
            minFreq++;
        }
        node.frequency++;
        DLL list = freq_map.getOrDefault(node.frequency, new DLL());
        list.offer(node);
        freq_map.put(node.frequency, list);
    }
    class Node {
        Node prev;
        Node next;
        int key;
        int value;
        int frequency;

        public Node(){}

        public Node(int key, int value, int frequency){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    class DLL {
        Node head = new Node();
        Node tail = new Node();
        int size;


        public DLL(){
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public void offer(Node newNode){
            head.next.prev = newNode;
            newNode.next = head.next;

            head.next = newNode;
            newNode.prev = head;
            size++;
        }

        public void remove(Node node){
            Node node_next = node.next;
            Node node_prev = node.prev;

            node_prev.next = node_next;
            node_next.prev = node_prev;
            size--;
        }


    }


}

