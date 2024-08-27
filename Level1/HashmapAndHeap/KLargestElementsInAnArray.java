package Level1.HashmapAndHeap;

import java.util.PriorityQueue;

public class KLargestElementsInAnArray {
    public static void getKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 7, 8, 9, 12};
        getKLargestElements(arr, 3);
    }
}
