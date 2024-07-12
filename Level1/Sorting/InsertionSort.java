package Level1.Sorting;

import java.util.Scanner;

import static Level1.Sorting.BubbleSort.Swap;

public class InsertionSort {
    public static int[] insertionSort(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    Swap(arr,j,j+1);
                }else {
                    break;
                }
            }
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

        int res[]=insertionSort(arr);
        for (int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
