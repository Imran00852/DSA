package Level1.RecursionAndBacktracking;

public class AllIndices {
    public static int[] getAllIndices(int arr[],int idx, int data,int fsf){
        if(idx==arr.length){
            return new int[fsf];
        }
        if(arr[idx]==data){
            int iarr[]=getAllIndices(arr,idx+1,data,fsf+1);
            iarr[fsf]=idx;
            return iarr;
        }else{
            int iarr[]=getAllIndices(arr,idx+1,data,fsf);
            return iarr;
        }
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,10,50,60,70,80,7,65,65,44,33,12,10,16,80};

        int res[]=getAllIndices(arr,0,80,0);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }
    }
}
