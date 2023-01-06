package MRA.DSA;

public class StackArray<T> {
    private int size;
    private int length;
    private Object [] data;

    public StackArray(int size){
        this.size = size;
        data = new Object[size];
        length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==size;
    }

    public boolean push(T value){
        if(isFull()){
            return false;
        }else{
            data[length++] = value;
            return true;
        }
    }

    public Object pop(){
       if (isEmpty()){
           return null;
       }else{
           return data[--length];
       }
    }

    public Object peek(){
        return data[length-1];
    }

    public void display(){

        if(isEmpty()){
            System.out.println("The Stack Is Empty..");
            return;
        }
        for (int i = length-1; i >=0 ; i--) {
            System.out.print( data[i]+" ");
        }

        System.out.println();
    }


}
