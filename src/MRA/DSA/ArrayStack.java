package MRA.DSA;

public class ArrayStack {
    private int size;
    private int length;
    private int [] data;

    public ArrayStack(int size){
        this.size = size;
        data = new int[size];
        length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public boolean isFull(){
        return length==size;
    }

    public boolean push(int value){
        if(isFull()){
            return false;
        }else{
            data[length++] = value;
            return true;
        }
    }

    public int pop(){
       if (isEmpty()){
           return 0;
       }else{
           return data[--length];
       }
    }

    public int peek(){
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
