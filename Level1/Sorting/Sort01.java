package Level1.Sorting;

import static Level1.Sorting.BubbleSort.Swap;

public class Sort01 {
    public static int[] sort01(int[] arr){
        int i=0;
        int j=0;

        while(i<arr.length){
            if(arr[i]==0){
                Swap(arr,i,j);
                i++;
                j++;
            }else {
                i++;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int arr[]={1,1,0,1,0,1,1,0,1,0,0,0,1};

        int res[]=sort01(arr);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
