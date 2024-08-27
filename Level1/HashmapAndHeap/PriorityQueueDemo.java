package Level1.HashmapAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(2);

        //smaller value has the highest priority by default

        //lets change the priority to highest values
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(9);
        pq2.add(10);
        pq2.add(60);
        while (pq2.size() > 0) {
            System.out.println(pq2.remove());
        }
    }
}
