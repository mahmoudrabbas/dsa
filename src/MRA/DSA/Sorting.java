package MRA.DSA;

public class Sorting {

    public void bubbleSort(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void selectionSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            swap(arr, min, i);
        }
    }

    public void insertionSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j>=0 ; j--) {
                if(arr[j+1] < arr[j]){
                    swap(arr, j+1, j);
                }
            }
        }
    }


    private void mergeSortedArrays(int [] arr1, int [] arr2, int [] arr3){
        int a = 0, b = 0;
        for (int i = 0; i < arr3.length; i++) {
            if(a == arr1.length){
                arr3[i] = arr2[b++];
            } else if (b == arr2.length) {
                arr3[i] = arr1[a++];
            }else {
                if(arr1[a] <= arr2[b]){
                    arr3[i] = arr1[a++];
                }else {
                    arr3[i] = arr2[b++];
                }
            }
        }
    }

    public void quickSort(int [] arr){
        quickSorting(arr, 0, arr.length-1);
    }


    private void quickSorting(int arr[], int first, int last){
        if(first<last){
            int pivot = partition(arr, first, last);
            quickSorting(arr, first, pivot-1);
            quickSorting(arr, pivot+1, last);
        }

    }


    public int partition(int [] arr, int first, int last){
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

            if(high>low){
                swap(arr, high, low);
            }
        }

        if(pivot>arr[high]){
            arr[first] = arr[high];
            arr[high] = pivot;
            return high;
        }
        return first;
    }

    public void mergeSort(int [] arr){
        if(arr.length>1){
            int [] arr1 = new int[arr.length/2];
            System.arraycopy(arr, 0, arr1, 0, arr1.length);
            mergeSort(arr1);

            int [] arr2 = new int[arr.length - arr1.length];
            System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
            mergeSort(arr2);

            mergeSortedArrays(arr1, arr2, arr);
        }
    }


    public void swap(int [] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
