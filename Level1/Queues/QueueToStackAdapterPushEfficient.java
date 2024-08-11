package Level1.Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackAdapterPushEfficient {
    public static void main(String[] args) {
        QueueToStack2 st = new QueueToStack2();
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

    public static class QueueToStack2 {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStack2() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);  //constant time
        }

        int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }
            return val;
        }

        int top() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            helperQ.add(val);

            while (helperQ.size() > 0) {
                mainQ.add(helperQ.remove());
            }

            return val;
        }
    }
}
