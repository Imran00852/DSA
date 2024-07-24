package Level1.LinkedList;

import java.util.LinkedList;

public class LinkedListToStackAdapter {
    static class LinkedListToStack{
        LinkedList<Integer> list;

        public LinkedListToStack(){
            list=new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        void push(int data){
            list.addFirst(data);
        }

        int pop(){
            if(list.size()==0) {
                return -1;
            }
            return list.removeFirst();
        }

        int top(){
            if(list.size()==0) {
                return -1;
            }
            return list.getFirst();
        }

        void display() {
            for (int element : list) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LinkedListToStack stack = new LinkedListToStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.pop());
        System.out.println(stack.top());

        stack.display();
    }
}
