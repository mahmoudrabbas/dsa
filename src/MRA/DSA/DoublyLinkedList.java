package MRA.DSA;

public class DoublyLinkedList {
    DoublyNode first;
    DoublyNode last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int value){
        DoublyNode newNode = new DoublyNode(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertLast(int value){
        DoublyNode newNode = new DoublyNode(value);
        if(isEmpty()) {
            last = newNode;
            first = newNode;
        }else{
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
    }

    public int deleteFirst(){
        int value = first.item;

        if(first.next == null){
            last = null;
        }else {
            first.next.prev = null;
        }
        first = first.next;
        return value;
    }


    public int deleteLast(){
        int value = last.item;
        if (last.prev == null){
            first= null;
        }else{
            last.prev.next=null;
        }

        last = last.prev;
        return value;
    }

    public boolean isFound(int value){
        DoublyNode current = first;
        boolean found = false;
        while (current != null){
            if(current.item == value){
                found = true;
            }
            current = current.next;
        }
        return found;
    }

    public boolean insertAfter(int element, int value){
        if(isEmpty()){
            return false;
        }else{
            if(!isFound(element)){
                insertLast(value);
            }else{
                DoublyNode current = first;
                while (current.item != element){
                    current = current.next;
                }

                DoublyNode newNode = new DoublyNode(value);
                if(current == last){
                    newNode.prev = last;
                    last.next = newNode;
                    last = newNode;
                }else{
                    newNode.next = current.next;
                    newNode.prev = current;
                    current.next.prev = newNode;
                    current.next = newNode;
                }
            }
            return true;
        }
    }


    public void push(int value){
        insertLast(value);
    }

    public int pop(){
        return deleteLast();
    }

    public void enqueue(int value){
        insertLast(value);
    }

    public int dequeue(){
        return deleteFirst();
    }


    public void displayFromFirst(){
        DoublyNode current = first;
        while (current != null){
            System.out.print(current.item+" ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayFromLast(){
        DoublyNode current = last;
        while (current != null){
            System.out.print(current.item+" ");
            current = current.prev;
        }
        System.out.println();
    }


}



class DoublyNode {
    int item;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(int item) {
        this.item = item;
    }

}
