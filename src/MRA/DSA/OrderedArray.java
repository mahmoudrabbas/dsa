package MRA.DSA;

public class OrderedArray {
    int size;
    int [] data;
    int length;

    public OrderedArray(int size){
        this.size = size;
        data = new int[size];
        length=0;
    }

    private boolean isEmpty(){
        return length==0;
    }
    private boolean isFull(){ return length==size; }

    public int find(int value){
        int min = 0;
        int max = length-1;
        while (true){
            int mid = (min+max)/2;
            if(data[mid] == value){
                return mid;
            } else if (min>max) {
                return -1;
            } else if (data[mid]>value) {
                max = mid-1;
            } else if (data[mid]<value) {
                min = mid+1;
            }
        }
    }

    public boolean insert(int value){
        if(isFull()){
            return false;
        }else{
            int i;
            for (i = 0; i < length; i++) {
                if(data[i] > value) {
                    break;
                }
            }

            length++;
            for(int j = length-1; j > i; j--){
                data[j] = data[j-1];
            }
            data[i] = value;
            return true;
        }
    }

    public boolean delete(int value){
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
