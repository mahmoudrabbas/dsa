package MRA.DSA;

public class OrderedArray<T> {
    private int size;
    private Object [] data;
    private int length;

    public OrderedArray(int size){
        this.size = size;
        data = new Object[size];
        length=0;
    }

    private boolean isEmpty(){
        return length==0;
    }
    private boolean isFull(){ return length==size; }

    public int find(T value){
        int min = 0;
        int max = length-1;
        while (true){
            int mid = (min+max)/2;
            if(data[mid] == value){
                return mid;
            } else if (min>max) {
                return -1;
            } else if ((Integer)data[mid]>(Integer)value) {
                max = mid-1;
            } else if ((Integer)data[mid]<(Integer) value) {
                min = mid+1;
            }
        }
    }
    public Object access(int index){
        return data[index];
    }

    public boolean insert(T value){
        if(isFull()){
            return false;
        }else{
            data[length++] = value;
            insertionSort();
            return true;
        }
    }

    public boolean delete(T value){
        if(isEmpty()){
            return false;
        }else{
            if(find(value) == -1){
                return false;
            }else{
                for (int i = find(value)+1; i < length; i++) {
                    data[i-1] = data[i];
                }

                length--;
                return true;
            }
        }
    }

    private void insertionSort(){
        for(int i=length-2; i>=0; i--){
            if((Integer)data[i] > (Integer) data[i+1]){
                swap(i, i+1);
            }
        }
    }

    private void swap(int a, int b){
        Object temp = data[a];
        data[a] = data[b];
        data[b] = temp;
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


}
