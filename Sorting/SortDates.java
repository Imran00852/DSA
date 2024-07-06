package Sorting;

import java.util.Scanner;

public class SortDates {
    public static void sortDates(String arr[]){
        countingSort2(arr,1000000,100,32); //day
        countingSort2(arr,10000,100,13); //month
        countingSort2(arr,1,10000,2501); //year
    }

    public static void countingSort2(String arr[],int div,int mod,int range){
        //frequency array
        int farr[] = new int[range];

        for (int i = 0; i < arr.length; i++) {
            farr[Integer.parseInt(arr[i],10)/ div % mod]++;
        }

        //make prefix array from frequency array
        for (int i = 1; i < farr.length; i++) {
            farr[i] = farr[i] + farr[i - 1];
        }
        //ans array
        String ans[] = new String[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
//            int val = Integer.parseInt(arr[i],10 / div % mod);
            int pos = farr[Integer.parseInt(arr[i],10)/ div % mod]-1;
            ans[pos] = arr[i];
            farr[Integer.parseInt(arr[i],10)/ div % mod]--;
        }

//        //copy ans in our original array arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }

    public static void printArr(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String arr[] = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        sortDates(arr);
        printArr(arr);
    }
}
