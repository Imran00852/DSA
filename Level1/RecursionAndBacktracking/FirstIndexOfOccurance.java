package Level1.RecursionAndBacktracking;

public class FirstIndexOfOccurance {
    public static int getFirstIndex(int arr[],int idx,int data){
        if(idx==arr.length){
            return -1;
        }
        if(arr[idx]==data){
            return idx;
        }else {
            int fiisa=getFirstIndex(arr,idx+1,data);
            return fiisa;
        }
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,10,50,60,70,80,7,65,65,44,33,12,10,16,80};
        System.out.println(getFirstIndex(arr,0,80));
    }
}
