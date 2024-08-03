package Level1.Stacks;

import java.util.Stack;

public class NextSmallerElementOnTheLeft {
    public static int[] getSmallerOnTheLeft(int arr[]){
        int nse[]=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                int pos=st.peek();
                nse[pos]=arr[i];
                st.pop();
            }

            st.push(i);
        }
        while(st.size()>0){
            int pos=st.peek();
            nse[pos]=-1;
            st.pop();
        }

        return nse;
    }
    public static void main(String[] args) {
        int arr[]={5,2,1,4}; //ans={1,-1,-1,1}
        int res[]=getSmallerOnTheLeft(arr);
        for(int val:res){
            System.out.print(val +" ");
        }
    }
}
