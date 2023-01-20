package MRA.DSA;
import java.util.LinkedList;
import java.util.Queue;
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

    public void bfs(){
        if(root == null) return;
        Queue<TNode> q = new LinkedList<TNode>();
        q.offer(root);
        TNode current;

        while (!q.isEmpty()){
            current = q.poll();
            System.out.print(current.item+" ");
            if(current.left != null){
                q.offer(current.left);
            }
            if(current.right != null){
                q.offer(current.right);
            }
        }
        System.out.println();
    }

    public void inOrder(){
        traversalInOrder(root);
        System.out.println();
    }
    public void preOrder(){
        traversalPreOrder(root);
        System.out.println();
    }
    public void postOrder(){
        traversalPostOrder(root);
        System.out.println();
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


    private TNode findSuccessor(TNode deletedNode){
        TNode parent = deletedNode;
        TNode successor = deletedNode;
        TNode current = successor.right;
        while (current!=null){
            parent = successor;
            successor = current;
            current = current.left;
        }

        if(successor != deletedNode.right){
            parent.left = successor.right;
            successor.right = deletedNode.right;
        }

        return successor;
    }


    public boolean delete(int value){
        if(!search(value)){
            return false;
        }else{
            TNode current = root;
            TNode parent = root;
            boolean isLeft= false;

            while (current.item != value){
                parent = current;
                if (current.item > value){
                    current = current.left;
                    isLeft = true;
                } else if (current.item < value) {
                    current = current.right;
                    isLeft = false;
                }
            }

            // if the node does not have right or left child

            if(current.left == null && current.right==null){
                // if the node does not have right or left child, and it is the root itself
                if(current == root){
                    root = null;
                } else if(isLeft){
                    parent.left = null;
                }else{
                    parent.right = null;
                }

            // if the node has only right child
            /*

            $$ this when the nude itself is left and has a right child

                   P
                 /   \
                X     B
                 \
                  RC


            $$ this when the nude itself is left and has a right child

                   P
                 /   \
                A     X
                       \
                        RC


            $$ the nude itself is the root and has a right child

                    X
                      \
                       C
                     /   \
                    A     B


            x => the nude I am deleting (current nude)
            P => parent nude

            */
            } else if (current.left == null) {
                if(current == root){
                    root = current.right;
                }else if (isLeft){
                    parent.left = current.right;
                }else {
                    parent.right = current.right;
                }
            // it has only left nude
            /*
            * */
            } else if (current.right == null) {
                if(current==root){
                    root = current.left;
                } else if (isLeft) {
                    parent.left = current.left;
                }else {
                    parent.right = current.left;
                }
            // it has left node and right node
            }else {
                TNode successor = findSuccessor(current);
                if (successor == current){
                    root = successor;
                }
                if(isLeft){
                    parent.left = successor;
                }else {
                    parent.right = successor;
                }

                successor.left = current.left;
            }


            return true;
        }
    }

    public boolean insert(int value){
        TNode newNode = new TNode(value);
        if(isEmpty()){
            root= newNode;
            return true;
        }else{
            if(search(value)){
                return false;
            }else{
                TNode current = root;
                TNode parent;

                while (true){
                    parent = current;
                    if(current.item > value){
                        current = current.left;
                        if(current==null){
                            parent.left = newNode;
                            return true;
                        }
                    } else if(current.item < value){
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
}

class TNode {
    int item;
    TNode right;
    TNode left;

    public TNode(int item){
        this.item = item;
    }

}