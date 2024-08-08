package Level1.Stacks;

public class NormalStack {
    public static class CustomStack{
        int data[];
        int tos; //top of stack

        public CustomStack(int cap){  //capacity
            data=new int[cap];
            tos=-1;
        }

        int size(){
            return tos+1;
        }

        void display(){
            for(int i=tos;i>=0;i--){
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        void push(int val){
            if(tos==data.length-1){
                System.out.println("Stack Overflow");
            }
            tos++;
            data[tos]=val;
        }
        int pop(){
            int val=data[tos];
            tos--;
            return val;
        }
        int top(){
            if(tos==-1){
                System.out.println("Stack Underflow");
                return -1;
            }else {
                return data[tos];
            }
        }
    }
    public static void main(String[] args) {
        CustomStack st=new CustomStack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st.pop());

        st.display();

    }
}
