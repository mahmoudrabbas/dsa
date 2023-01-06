package MRA.DSA;

public class QueueArray<T> {
    int size;
    Object [] data;
    int length;
    int front;
    int rear;

    public QueueArray(int size){
        this.size = size;
        data = new Object[size];
        length = 0;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==size;
    }

    public boolean enqueue(T value){
        if(isFull()){
            return false;
        }else {
            rear =++rear%size;
            data[rear] = value;
            length++;
            return true;
        }
    }

    public Object dequeue(){
        if(isEmpty()){
            return null;
        }else {
            length--;
            front = ++front%size;
            return data[front];
        }
    }

    public void display(){
        if(isEmpty()){
            return;
        }
        for (int i = 0; i < length ; i++) {
            System.out.print(data[++front%size] +" ");
        }
        System.out.println();
    }
}
