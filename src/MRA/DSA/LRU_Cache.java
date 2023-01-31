package MRA.DSA;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
    CacheNode head = new CacheNode();
    CacheNode tail = new CacheNode();
    Map<Integer, CacheNode> lru_cache;
    int capacity;

    public LRU_Cache(int capacity){
        this.capacity = capacity;
        lru_cache = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    // O(1)
    public void put(int key, int val) {
        CacheNode node = lru_cache.get(key);
        if(node != null){
            remove(node);
            node.val = val;
            add(node);
            lru_cache.put(key, node);
        }else {
            node = new CacheNode(key, val);
            if(lru_cache.size() == capacity){
                CacheNode tail_prev = lru_cache.get(tail.prev.key);
                lru_cache.remove(tail.prev.key);
                remove(tail_prev);
            }
            lru_cache.put(key, node);
            add(node);
        }
    }

    // O(1)
    public int get(int key){
        int val = 0;
        CacheNode node = lru_cache.get(key);
        if(node!=null){
            val = node.val;
            remove(node);
            add(node);
        }
        return val;
    }

    private void add(CacheNode node){
        CacheNode head_next = head.next;

        head_next.prev = node;
        node.next = head_next;
        head.next = node;
        node.prev = head;
    }

    private void remove(CacheNode node){

        CacheNode node_next = node.next;
        CacheNode node_prev = node.prev;

        node_prev.next = node_next;
        node_next.prev = node_prev;

//
//        node.next.prev = node.prev;
//        node.prev.next = node.next;
    }

    // O(n)
    public void cache_display(){
        CacheNode temp = head;
        while (temp.next != tail){
            temp = temp.next;
            System.out.print(temp.val+" ");
        }
        System.out.println();
    }

}


