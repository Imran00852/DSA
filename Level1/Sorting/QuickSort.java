package Level1.Sorting;

import static Level1.Arrays.ArrayPartition.arrayPartition;

public class QuickSort {
    public static void quickSort(int arr[], int lo,int hi){
        if(lo>=hi){
            return;
        }
        int pivot=arr[hi];

        int pi=arrayPartition(arr,lo,hi,pivot);
        quickSort(arr,0,pi-1);
        quickSort(arr,pi+1,hi);
    }
    public static void main(String[] args) {
        int arr[]={6,10,12,8,7,4,9};
        quickSort(arr,0,arr.length-1);

        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
