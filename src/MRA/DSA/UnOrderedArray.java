package MRA.DSA;

public class UnOrderedArray {
    int size;
    int [] data;
    int length;

    public UnOrderedArray(int size){
        this.size = size;
        data = new int[size];
        length = 0;
    }

    private boolean isEmpty(){
        return length==0;
    }
    private boolean isFull(){
        return length==size;
    }

    public int find(int value){
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
    public boolean insert(int value){
        if(isFull()){
            return false;
        }else {
            data[length++] = value;
            return true;
        }
    }

    public boolean delete(int value){
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
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public void bubbleSort(){
        for (int k = 0; k < length-1; k++) {
            for (int i = 0; i < length-1-k; i++) {
                if(data[i]>data[i+1]){
                    swap(i, i+1);
                }
            }
        }
    }


    public void selectionSort(){

        for (int i = 0; i < length-1; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if(data[j]<data[min]){
                    min = j;
                }
            }
            swap(min, i);
        }

    }

    public void insertionSort(){
        for (int i = 1; i < length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(data[j]>data[j+1]){
                    swap(j, j+1);
                }
            }
        }
    }

    public void mergeSort(){
        mergeSorting(data);
    }
    private void mergeSorting(int [] arr){
        if (arr.length > 1){
            int [] arr1 = new int[arr.length/2];
            System.arraycopy(arr, 0, arr1, 0, arr1.length);
            mergeSorting(arr1);

            int [] arr2 = new int[arr.length-arr1.length];
            System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
            mergeSorting(arr2);


            mergeSorted(arr1, arr2, arr);

        }
    }

    private void mergeSorted(int [] arr1, int [] arr2, int [] arr3){
        int a = 0;
        int b = 0;

        for (int i = 0; i < arr3.length; i++) {
            if(a==arr1.length){
                arr3[i] = arr2[b++];
            } else if (b==arr2.length) {
                arr3[i] = arr1[a++];
            }else if(arr1[a] <= arr2[b]){
                arr3[i] = arr1[a++];
            }else if(arr1[a] > arr2[b]){
                arr3[i] = arr2[b++];
            }
        }
    }

    public void quickSort(){
        quickSorting(data, 0, data.length-1);
    }
    private void quickSorting(int [] arr, int first, int last){
        if(first<last){
            int pivotIndex = partition(arr, first, last);
            quickSorting(arr, first, pivotIndex-1);
            quickSorting(arr, pivotIndex+1, last);
        }

    }

    private int partition(int [] arr, int first, int last){
        int pivot = arr[first];
        int low = first+1;
        int high = last;

        while (high>low){
            while (arr[high]>pivot){
                high--;
            }
            while (high>=low && arr[low]<=pivot){
                low++;
            }


            if(high > low){
                swap(arr, high, low);
            }
        }
        if(arr[high]<pivot){
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        }else {
            return first;
        }
    }

    public void swap(int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }






    public int getLength(){
        return length;
    }

    public int getSize(){
        return size;
    }

}
