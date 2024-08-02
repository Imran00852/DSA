package Level1.Stacks;

import java.util.Stack;

public class StockSpan {
    public static int[] stockSpan(int arr[]){
        int span[]=new int[arr.length];
        span[0]=1;
        Stack<Integer>st=new Stack<>();
        st.push(0);
        for(int i=1;i< arr.length;i++){
            while(st.size()>0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }

            if(st.size()==0){
                span[i]=i+1;
            }else {
                span[i]=i-st.peek();
            }

            st.push(i);
        }

        return span;
    }
    public static void main(String[] args) {
        int arr[]={2,4,1,8,9,10,12,2};
        int res[]=stockSpan(arr);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
