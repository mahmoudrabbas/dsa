import MRA.DSA.BinaryTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("In The Name Of Allah");
        BinaryTree t1 = new BinaryTree();


        t1.insert(5);
        t1.insert(7);
        t1.insert(8);
        t1.insert(4);
        t1.insert(6);

        System.out.print("InOrder Traversing   => ");
        t1.inOrder();
        System.out.print("\nPreOrder Traversing  => ");
        t1.preOrder();
        System.out.print("\nPostOrder Traversing => ");
        t1.postOrder();



    }

}

