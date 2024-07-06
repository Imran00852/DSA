package Sorting;

import java.util.Arrays;

public class TargetSumPair {
    public static void targetSumPair(int[] arr,int target){
        Arrays.sort(arr);

        int i=0;
        int j=arr.length-1;

        while(i<j){
            if(arr[i]+arr[j]>target){
                j--;
            } else if (arr[i]+arr[j]<target) {
                i++;
            }else{
                System.out.print("(" + arr[i] + "," + arr[j]+ ")");
                i++;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={10,90,80,40,65,76,100,20,50,88,87,120};
        int target=100;

        targetSumPair(arr,target);
    }
}
