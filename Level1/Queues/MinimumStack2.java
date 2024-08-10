package Level1.Queues;

import java.util.Stack;

public class MinimumStack2 {
    public static void main(String[] args) {
        MinStack2 st = new MinStack2();
        st.push(10);
        st.push(2);
        st.push(30);
        st.push(1);

        System.out.println(st.top());
        System.out.println(st.min());
        System.out.println(st.pop());
    }

    public static class MinStack2 {
        Stack<Integer> data;
        int min;


        public MinStack2() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else {
                if (val >= min) {
                    data.push(val);
                } else {
                    data.push(val + val - min);
                    min = val;
                }
            }
        }

        int pop() {
            if (data.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            if (data.peek() > min) {
                return data.pop();
            } else {
                int originalvalue = min;
                min = 2 * min - data.pop();
                return originalvalue;
            }
        }

        int top() {
            if (data.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            if (data.peek() < min) {
                return min;
            } else {
                return data.peek();
            }
        }

        int min() {
            if (data.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return min;
        }
    }
}
