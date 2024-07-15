package Level1.RecursionAndBacktracking;

public class LastIndexOfOccurance {
    public static int getLastIndex(int arr[],int idx,int data){
        if(idx==arr.length){
            return -1;
        }
        int lisa=getLastIndex(arr,idx+1,data);
        if(lisa==-1){
            if(arr[idx]==data){
                return idx;
            }else{
                return -1;
            }
        }else{
            return lisa;
        }
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,10,50,60,70,80,7,65,65,44,33,12,10,16,80};
        System.out.println(getLastIndex(arr,0,80));
    }
}
