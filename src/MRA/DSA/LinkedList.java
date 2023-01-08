package MRA.DSA;

public class LinkedList {
    Node head;

    public LinkedList(){
        head = null;
    }

    private boolean isEmpty(){
        return head==null;
    }

    public void insertInBeginning(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(int element, int value){
        if(!isFound(element)){
            insertInBeginning(value);
        }else{
            Node temp = head;
            while (temp.item != element){
                temp = temp.next;
            }
            Node newNode = new Node(value);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public int deleteFromBeginning(){
        if (isEmpty()){
            return 0;
        }else {
            int value = head.item;
            head = head.next;
            return value;
        }

    }

    public boolean deleteByValue(int value){
        if(isEmpty()){
            return false;
        }else{
            if(!isFound(value)){
                return false;
            }else{
                Node current = head;
                Node prev = head;

                while (current.item != value){
                    prev = current;
                    current = current.next;
                }

                if(current == prev){
                    head = head.next;
                }else {
                    prev.next = current.next;
                }
                return true;
            }
        }
    }

    public boolean isFound(int value){
        Node temp = head;
        while (temp!=null){
            if(temp.item == value){
                break;
            }else {
                temp = temp.next;
            }
        }
        if(temp==null){
            return false;
        }else {
            return true;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("LinkedList is empty...");
            return;
        }
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.item+" ");
            temp = temp.next;
        }

        System.out.println();
    }

}


class Node {
    int item;
    Node next;

    public Node(int item){
        this.item = item;
    }
}


