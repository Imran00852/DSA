package Sorting;

//quickSelect or find kth smallest element in an array

import static Arrays.ArrayPartition.arrayPartition;

public class QuickSelect {
    public static int quickSelect(int arr[],int lo,int hi,int k){
        int pivot=arr[hi];
        int pi=arrayPartition(arr,lo,hi,pivot);

        if(k>pi){
            return quickSelect(arr,pi+1,hi,k);
        } else if (k<pi) {
            return quickSelect(arr,0,pi-1,k);
        }else {
            return pivot;
        }
    }
    public static void main(String[] args) {
        int arr[]={2,11,8,7,9,6,5,4,3};
        int k=2;

        System.out.print(quickSelect(arr,0,arr.length-1,k-1));
    }
}
