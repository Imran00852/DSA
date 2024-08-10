package Level1.Queues;

import java.util.Stack;

public class MinimumStack1 {
    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(10);
        st.push(2);
        st.push(30);
        st.push(1);

        System.out.println(st.top());
        System.out.println(st.min());
        System.out.println(st.pop());
    }

    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            allData.push(val);
            if (minData.isEmpty() || val <= minData.peek()) {
                minData.push(val);
            }
        }

        int pop() {
            if (allData.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            int val = allData.pop();

            if (val == minData.peek()) {
                minData.pop();
            }
            return val;
        }

        int top() {
            if (allData.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return allData.peek();
        }

        int min() {
            if (minData.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return minData.peek();
        }
    }
}
