package Level1.Stacks;

import java.util.Stack;

public class NextGreaterElementOnTheRight {
    public static int[] getNextGreaterElement(int arr[]){
        int nge[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(0);

        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                int pos=st.peek();
                nge[pos]=arr[i];
                st.pop();
            }
            st.push(i);
        }

        while(st.size()>0){
            int pos=st.peek();
            nge[pos]=-1;
            st.pop();
        }

        return nge;
    }
    public static void main(String[] args) {
        int arr[]={5,2,1,4};
        int res[]=getNextGreaterElement(arr);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
