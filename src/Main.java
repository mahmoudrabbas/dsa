import MRA.DSA.BinaryTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("In The Name Of Allah");
        BinaryTree bt = new BinaryTree();


        bt.insert(50);
        bt.insert(25);
        bt.insert(35);
        bt.insert(40);
        bt.insert(30);
        bt.insert(15);
        bt.insert(20);
        bt.insert(5);

        bt.inOrder();
        bt.delete(25);
        bt.inOrder();

    }

}

