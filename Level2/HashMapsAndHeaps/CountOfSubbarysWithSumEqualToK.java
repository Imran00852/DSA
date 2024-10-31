package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubbarysWithSumEqualToK {
    public static int getCountOfSubarrays(int[] arr, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - k)) {
                ans += hm.get(sum - k);
            } else {
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
        System.out.println(getCountOfSubarrays(arr, 5));
    }
}
