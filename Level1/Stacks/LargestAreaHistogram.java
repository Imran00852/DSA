package Level1.Stacks;

import java.util.Stack;

public class LargestAreaHistogram {
    public static int largestAreaHistogram(int arr[]){
        //right boundary
        //next smaller element on the right(start from left)
        int rb[]=new int[arr.length];
        rb[arr.length-1]=arr.length;
        Stack<Integer>st=new Stack<>();
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                rb[i]=arr.length;
            }else {
                rb[i]=st.peek();
            }
            st.push(i);
        }
        //left boundary
        //next smaller element on the left

        int lb[]=new int[arr.length];
        rb[0]=-1;
        st=new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                lb[i]=-1;
            }else {
            lb[i]=st.peek();
            }
            st.push(i);
        }

        int maxArea=0;
        for(int i=0;i<arr.length;i++){
            int width=rb[i]-lb[i]-1;
            int area=arr[i]*width;

            if(area>=maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int arr[]={6,2,5,4,5,1,6};
        System.out.println(largestAreaHistogram(arr));
    }
}
