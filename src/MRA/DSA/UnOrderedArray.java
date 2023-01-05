package MRA.DSA;

public class UnOrderedArray<T> {
    int size;
    Object [] data;
    int length;

    public UnOrderedArray(int size){
        this.size = size;
        data = new Object[size];
        length = 0;
    }

    private boolean isEmpty(){
        return length==0;
    }
    private boolean isFull(){
        return length==size;
    }

    public int find(T value){
        int index = -1;
        for (int i = 0; i < length; i++) {
            if(data[i] == value){
                index = i;
            }
        }

        return index;
    }

    public int access(int index){
        return (Integer) data[index];
    }
    public boolean insert(T value){
        if(isFull()){
            return false;
        }else {
            data[length++] = value;
            return true;
        }
    }

    public boolean delete(T value){
        if(find(value) == -1){
            return false;
        }else {
            for (int i = find(value)+1; i <length ; i++) {
                data[i-1] = data[i];
            }

            length--;
            return true;
        }
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Empty Array");
        }else{
            for (int i = 0; i < length; i++) {
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
    }

    private void swap(int a, int b){
        Object temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void bubbleSort(){
        for (int k = 0; k < length-1; k++) {
            for (int i = 0; i < length-1-k; i++) {
                if((Integer)data[i]>(Integer)data[i+1]){
                    swap(i, i+1);
                }
            }
        }
    }


    public void selectionSort(){

        for (int i = 0; i < length-1; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if((Integer)data[j]<(Integer)data[min]){
                    min = j;
                }
            }
            swap(min, i);
        }

    }

    public void insertionSort(){
        for (int i = 1; i < length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if((Integer)data[j]>(Integer)data[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }




    public int getLength(){
        return length;
    }

    public int getSize(){
        return size;
    }

}
