package Level1.Stacks;

import java.util.Stack;

public class SlidingWindowMaximum {
    public static int[] slidingWinMax(int arr[],int k){
        //next greater element on the right
        int nge[]=new int[arr.length];
        nge[arr.length-1]=arr.length;
        Stack<Integer>st=new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=arr.length;
            }else {
                nge[i]=st.peek();
            }

            st.push(i);
        }
        int res[]=new int[arr.length-k+1];

        int j=0;
        for(int i=0;i<=arr.length-k;i++){
            if(j<i){
                j=i;
            }
            while(nge[j]<i+k){
                j=nge[j];
            }

            res[i]=arr[j];
        }

        return res;
    }
    public static void main(String[] args) {
        int arr[]={3,6,4,7,5};
        int res[]=slidingWinMax(arr,3);
        for(int val:res){
            System.out.print(val + " ");
        }
    }
}
