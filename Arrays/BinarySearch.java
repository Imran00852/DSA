package Arrays;

public class BinarySearch {
    public static int binSearch(int arr[],int data){
        int lo=0;
        int hi=arr.length-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;

            if(data>arr[mid]){
                lo=mid+1;
            }else if(data<arr[mid]){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={20,30,40,50,60,70,80,90,100};
        int data=80;
        System.out.println(binSearch(arr,data));
    }
}
