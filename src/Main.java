import MRA.DSA.LRU_Cache;

public class Main {
    public static void main(String[] args) {
        LRU_Cache cache = new LRU_Cache(5);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);

        cache.cache_display();

        cache.put(6, 6);
        cache.cache_display();



        cache.put(7, 7);
        cache.cache_display();

        cache.put(8, 8);
        cache.cache_display();


        System.out.println(cache.get(4));
        cache.cache_display();
    }
}



