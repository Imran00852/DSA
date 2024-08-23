package Level1.HashmapAndHeap;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void getLongestSeq(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, true);
        }
        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int maxStartPoint = 0;
        int maxLength = 0;
        for (int val : arr) {
            if (map.containsKey(val) == true) {
                int tempLength = 1;
                int tempStartPoint = val;
                while (map.containsKey(tempStartPoint + tempLength)) {
                    tempLength++;
                }
                if (tempLength > maxLength) {
                    maxStartPoint = tempStartPoint;
                    maxLength = tempLength;
                }
            }
        }
        for (int i = 0; i < maxLength; i++) {
            System.out.print(maxStartPoint + i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 9, 1, 11, 8, 6, 3, 12, 2};
        getLongestSeq(arr);
    }
}
