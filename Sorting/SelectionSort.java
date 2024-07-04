package Sorting;

import java.util.Scanner;

import static Sorting.BubbleSort.Swap;

public class SelectionSort {
    public static int[] selectionSort(int arr[]){
        for (int i=0;i<arr.length-1;i++){
            int mi=i;

            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mi]){
                    mi=j;
                }
            }
            Swap(arr,i,mi);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int res[]=selectionSort(arr);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }


}
