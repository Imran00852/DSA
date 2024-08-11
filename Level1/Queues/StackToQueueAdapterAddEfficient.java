package Level1.Queues;

import java.util.Stack;

public class StackToQueueAdapterAddEfficient {
    public static void main(String[] args) {
        StackToQueue2 q = new StackToQueue2();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        while (q.size() > 0) {
            System.out.print(q.remove() + " ");
        }
    }

    public static class StackToQueue2 {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueue2() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue is empty");
                return -1;
            }
            if (size() == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            while (mainS.size() > 1) {
                helperS.push(mainS.pop());
            }
            int val = mainS.pop();
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }

            return val;

        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            while (mainS.size() > 1) {
                helperS.push(mainS.pop());
            }
            int val = mainS.pop();
            helperS.push(val);
            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }

            return val;
        }
    }
}
