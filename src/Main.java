import MRA.DSA.BinaryTree;
import MRA.DSA.HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String> ht = new HashTable<String>(3);
        ht.put(10,"Mahmoud");
        ht.put(5,"Hend");
        ht.put(8,"Abeer");
        ht.put(6,"ali");
        System.out.println(ht.get(8));
        System.out.println(ht.get(8));
        System.out.println(ht.get(5));
        System.out.println(ht.get(7));
        System.out.println(ht.search(6));
        System.out.println(ht.remove(6));
        System.out.println(ht.search(6));

        System.out.println(ht.search(8));
        System.out.println(ht.remove(8));
        System.out.println(ht.search(8));
    }
}



