package MRA.DSA;

public class PriorityQueueArray<T> {
    int size;
    Object [] data;
    int length;

    public PriorityQueueArray(int size){
        this.size = size;
        data = new Object[size];
        length=0;
    }

    public boolean isEmpty() {return length==0;};
    public boolean isFull() {return length==size;};

    public boolean enqueue(T value){
        if(isFull()){
            return false;
        }else{
            if(isEmpty()){
                data[length++] = value;
            }else {
                length++;
                int i;
                for(i=0; i<length-1; i++){
                    if((Integer)Integer.parseInt(value+"")<=(Integer)Integer.parseInt(data[i]+"")){
                        break;
                    }
                }

                for (int j = length-1; j > i; j--) {
                    data[j] = data[j-1];
                }

                data[i] = value;
            }
            return true;
        }
    }

    public Object dequeue(){
        if (isEmpty()){
            return 0;
        }else{
            return data[--length];
        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Queue Is Empty...");
            return;
        }
        for (int i = length-1; i >=0 ; i--) {
            System.out.print( data[i]+" ");
        }
        System.out.println();
    }
}
