import MRA.DSA.LFU_Cache;

public class Main {
    public static void main(String[] args) {

        LFU_Cache lfu = new LFU_Cache(2);

        lfu.put(1,1);
        lfu.put(2,2);
        System.out.println(lfu.get(1));
        lfu.put(3,3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,4);
        System.out.println(lfu.get(1));

    }
}



