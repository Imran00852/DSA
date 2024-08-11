package Level1.Queues;

import java.util.Stack;

public class StackToQueueAdapterRemoveEfficient {
    public static void main(String[] args) {
        StackToQueue q = new StackToQueue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        while (q.size() > 0) {
            System.out.print(q.remove() + " ");
        }
    }

    public static class StackToQueue {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueue() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.size() > 0) {
                helperS.push(mainS.pop());
            }
            mainS.push(val);

            while (helperS.size() > 0) {
                mainS.push(helperS.pop());
            }
        }

        int remove() {
            if (size() == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            return mainS.pop();
        }

        int peek() {
            if (size() == 0) {
                System.out.println("Queue is empty");
                return -1;
            }

            return mainS.peek();
        }
    }
}
