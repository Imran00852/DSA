package Level1.RecursionAndBacktracking;

public class TargetSumSubsets {
    public static void getTargetSumSubsets(int arr[],int idx, int target,int sos,String subsets){
        if(idx==arr.length){
            if(sos==target){
                System.out.println(subsets+".");
            }
            return;
        }
        getTargetSumSubsets(arr,idx+1,target,sos+arr[idx],subsets+arr[idx]+",");
        getTargetSumSubsets(arr,idx+1,target,sos,subsets);
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60};
        int target=60;

        getTargetSumSubsets(arr,0,target,0,""); //sos==>sum of subsets
    }
}
