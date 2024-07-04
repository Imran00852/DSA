package Sorting;

import java.util.Scanner;

import static Arrays.MergeTwoSortedArrays.mergedArrays;

public class MergeSort {
    public static int[] mergeSort(int arr[],int lo,int hi){
        if(lo==hi){
            int ba[]=new int[1];
            ba[0]=arr[lo];
            return ba;
        }
        int mid=(lo+hi)/2;

        int[] fsh=mergeSort(arr,lo,mid);
        int[] ssh=mergeSort(arr,mid+1,hi);

        int[] fsa=mergedArrays(fsh,ssh);

        return fsa;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i< arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int res[]=mergeSort(arr,0, arr.length-1);
        for (int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
