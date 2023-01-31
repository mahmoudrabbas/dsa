package MRA.DSA;

public class CacheNode {
    int key;
    int val;
    int frequency;
    public CacheNode prev;
    public CacheNode next;

    public CacheNode() {
    }

    public CacheNode(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public CacheNode(int key, int value, int frequency) {
        this.key = key;
        this.val = value;
        this.frequency = frequency;
    }
}

