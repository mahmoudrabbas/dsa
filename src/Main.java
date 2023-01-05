import MRA.DSA.UnOrderedArray;

public class Main {
    public static void main(String[] args) {
        UnOrderedArray<Integer> arr = new UnOrderedArray<>(5);
        arr.insert(9);
        arr.insert(4);
        arr.insert(5);
        arr.insert(8);
        arr.insert(3);

        arr.selectionSort();

        arr.display();

    }
}