package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    public static int getLargestSubArr(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = -1;
        int sum = 0;
        int maxLength = 0;
        hm.put(sum, i);
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            } else {
                int len = i - hm.get(sum);
                maxLength = Math.max(len, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        System.out.println(getLargestSubArr(arr));
    }
}
