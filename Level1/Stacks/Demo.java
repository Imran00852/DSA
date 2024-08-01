package Level1.Stacks;

import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
//        st.push(10);
//        st.push(20);
//        st.push(30);
//        st.push(40);
//
        for(int i=10;i<50;i+=10){
            st.push(i);
        }

        System.out.println(st);
        System.out.println(st.peek());
        System.out.println(st.size());
    }
}
