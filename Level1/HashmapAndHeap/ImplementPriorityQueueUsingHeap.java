package Level1.HashmapAndHeap;

import java.util.ArrayList;

public class ImplementPriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        //o(n) constructor
        public PriorityQueue(int[] arr) {
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }

            for (int i = data.size() - 2; i >= 0; i--) {
                downheapify(i);
            }
        }

        public int size() {
            return data.size();
        }

        private void swap(int i, int j) {
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        private void upheapify(int i) {
            if (i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if (data.get(i) < data.get(pi)) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Nothing in queue");
                return -1;
            }

            return data.get(0);
        }

        private void downheapify(int pi) {
            int mini = pi;

            int li = (2 * pi) + 1;
            if (li < data.size() && data.get(mini) > data.get(li)) {
                mini = li;
            }
            int ri = (2 * pi) + 2;
            if (ri < data.size() && data.get(mini) > data.get(ri)) {
                mini = ri;
            }

            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Nothing in queue");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        System.out.println(pq.peek());
    }
}
