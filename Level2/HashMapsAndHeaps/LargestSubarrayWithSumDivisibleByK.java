package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class LargestSubarrayWithSumDivisibleByK {
    public static int getLengthOfLargestSubarr(int[] arr, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int rem = 0;
        hm.put(rem, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            if (hm.containsKey(rem)) {
                int idx = hm.get(rem);
                int len = i - idx;
                ans = Math.max(ans, len);
            } else {
                hm.put(rem, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 8, 1, 7, 3, 6, 1, 9, 2, 7, 3};
        System.out.println(getLengthOfLargestSubarr(arr, 5));
    }
}
