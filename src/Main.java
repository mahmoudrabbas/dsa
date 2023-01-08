import MRA.DSA.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ls = new LinkedList();
        ls.insertInBeginning(5);
        ls.insertInBeginning(6);
        ls.insertInBeginning(7);
        ls.insertInBeginning(8);
        ls.display();


        ls.insertAfter(5, 9);
        ls.display();


    }
}