package Level1.Stacks;

public class DynamicStack {
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
               int[] ndata=new int[2* data.length];
               for (int i=0;i< data.length;i++){
                   ndata[i]=data[i];
               }
               data=ndata;
               tos++;
               data[tos]=val;
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

    }
}
