package Level1.Sorting;

public class CountSort {
    public static void countSort(int arr[],int max, int min){
        //range
        int range=max-min+1;

        //frequency array
        int farr[]=new int[range];

        for(int i=0;i<arr.length;i++){
            int idx=arr[i]-min;
            farr[idx]++;
        }

        //make prefix array from frequency array
        for(int i=1;i<farr.length;i++){
            farr[i]=farr[i]+farr[i-1];
        }
        //ans array
        int ans[]=new int[arr.length];
        for (int i= arr.length-1;i>=0;i--){
            int val=arr[i];
            int pos=farr[val-min];
            int idx=pos-1;
            ans[idx]=val;
            farr[val-min]--;
        }

        //print result
        for (int i=0;i< ans.length;i++){
        System.out.print(ans[i] +" ");
        }
    }
    public static void main(String[] args) {
        int arr[]={3,6,8,9,4,3,7,7,6,5};
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        int min =arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]< min){
                min =arr[i];
            }
        }
        countSort(arr,max,min);

    }
}
