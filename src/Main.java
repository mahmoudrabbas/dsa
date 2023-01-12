import MRA.DSA.UnOrderedArray;

public class Main {
    public static void main(String[] args) {
        UnOrderedArray ua = new UnOrderedArray(5);
        ua.insert(8);
        ua.insert(4);
        ua.insert(5);
        ua.insert(9);
        ua.insert(1);

        ua.display();
//        ua.mergeSort();
        ua.quickSort();
        ua.display();


    }


}