package Level1.Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPopEfficient {
    public static void main(String[] args) {
        QueueToStack st = new QueueToStack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        while (st.size() > 0) {
            System.out.print(st.pop() + " ");
        }

    }

    public static class QueueToStack {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStack() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            while (!mainQ.isEmpty()) {
                helperQ.add(mainQ.remove());
            }
            mainQ.add(val);

            while (!helperQ.isEmpty()) {
                mainQ.add(helperQ.remove());
            }
        }

        int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return mainQ.remove();
        }

        int top() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return mainQ.peek();
        }
    }
}
