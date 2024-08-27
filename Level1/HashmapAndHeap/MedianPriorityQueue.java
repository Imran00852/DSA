package Level1.HashmapAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
    public static class MedianPrQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPrQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        int size() {
            return left.size() + right.size();
        }

        int remove() {
            if (this.size() == 0) {
                System.out.println("Nothing in the Queue");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        int peek() {
            if (this.size() == 0) {
                System.out.println("Nothing in the Queue");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            } else if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

    }

    public static void main(String[] args) {
        MedianPrQueue pq = new MedianPrQueue();
        pq.add(10);
        pq.add(20);
        pq.add(30);

        System.out.println(pq.remove());
    }
}
