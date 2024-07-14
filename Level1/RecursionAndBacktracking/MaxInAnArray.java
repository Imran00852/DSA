package Level1.RecursionAndBacktracking;

public class MaxInAnArray {
    public static int getMaxElement(int arr[],int idx){
        if(idx== arr.length-1){
            return arr[idx];
        }
        int misa=getMaxElement(arr,idx+1);
        if(misa>arr[idx]){
            return misa;
        }else{
            return arr[idx];
        }
    }
    public static void main(String[] args) {
        int arr[]={10,30,50,70,20,120,80};
        System.out.println(getMaxElement(arr,0));
    }
}
