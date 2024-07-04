package Arrays;

import java.util.Scanner;

import static Sorting.BubbleSort.Swap;

public class ArrayPartition {
    public static int arrayPartition(int arr[],int lo, int hi,int pivot){
        int i=lo;
        int j=lo;

        while (i<arr.length){
            if(arr[i]<=pivot){
                Swap(arr,i,j);
                i++;
                j++;
            }else{
                i++;
            }
        }

        return j-1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        int pi=arrayPartition(arr,0,arr.length,14);
        System.out.println(pi);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
