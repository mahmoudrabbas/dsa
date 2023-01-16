package MRA.DSA;

public class BinaryTree {
    TNode root;

    public BinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean search(int value){
        TNode current = root;

        while (current.item != value){
            if(current.item > value){
                current = current.left;
                if (current==null){
                    return false;
                }
            }
            if(current.item < value){
                current = current.right;
                if (current==null){
                    return false;
                }
            }
        }

        return true;


    }

    public void inOrder(){
        traversalInOrder(root);
    }
    public void preOrder(){
        traversalPreOrder(root);
    }
    public void postOrder(){
        traversalPostOrder(root);
    }
    private void traversalInOrder(TNode tNode){
        if(tNode != null){
            traversalInOrder(tNode.left);
            System.out.print(tNode.item+" ");
            traversalInOrder(tNode.right);
        }
    }

    private void traversalPreOrder(TNode tNode){
        if(tNode != null){
            System.out.print(tNode.item+" ");
            traversalPreOrder(tNode.left);
            traversalPreOrder(tNode.right);
        }
    }
    private void traversalPostOrder(TNode tNode){
        if(tNode != null){
            traversalPostOrder(tNode.left);
            traversalPostOrder(tNode.right);
            System.out.print(tNode.item+" ");
        }
    }

    public boolean insert(int value){
        TNode newNode = new TNode(value);
        if(isEmpty()){
            root= newNode;
            return true;
        }else{
            TNode current = root;
            TNode parent = root;

            while (true){
                parent = current;
                if(current.item > value){
                    current = current.left;
                    if(current==null){
                        parent.left = newNode;
                        return true;
                    }
                }
                if(current.item < value){
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        return true;
                    }
                }
            }
        }
    }
}


class TNode {
    int item;
    TNode right;
    TNode left;

    public TNode(int item){
        this.item = item;
    }

}