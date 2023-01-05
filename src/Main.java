import MRA.DSA.OrderedArray;
import MRA.DSA.UnOrderedArray;

public class Main {
    public static void main(String[] args) {
        UnOrderedArray<Integer> uoa = new UnOrderedArray(5);
        uoa.insert(7);
        uoa.insert(9);
        uoa.insert(10);
        uoa.insert(8);
        uoa.insert(5);
        uoa.display();
        uoa.insertionSort();
        uoa.display();

    }

    public static void insertionSort(int [] arr){
        for(int i=arr.length-2; i>=0; i--){
            if(arr[i] > arr[i+1]){
                swap(arr, i, i+1);
            }
        }
    }

    public static void swap(int [] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}