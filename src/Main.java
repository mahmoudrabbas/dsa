import MRA.DSA.Sorting;

public class Main {
    public static void main(String[] args) {
        int [] arr = {5,9,2,7,4,3,6,8};

        Sorting sorting = new Sorting();

        sorting.quickSort(arr);

        for (int a: arr) {
            System.out.print(a+" ");
        }
        System.out.println();

    }
}



