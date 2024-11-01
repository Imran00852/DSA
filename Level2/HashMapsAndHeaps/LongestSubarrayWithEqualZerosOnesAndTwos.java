package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class LongestSubarrayWithEqualZerosOnesAndTwos {
    public static int getLargestSubArrOFEqual012(int[] arr) {
        int ans = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int zerosc = 0; //zeros count
        int onesc = 0;
        int twosc = 0;

        int delta10 = onesc - zerosc;
        int delta21 = twosc - onesc;

        String key = delta10 + "#" + delta21;
        hm.put(key, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zerosc++;
            } else if (arr[i] == 1) {
                onesc++;
            } else {
                twosc++;
            }

            delta10 = onesc - zerosc;
            delta21 = twosc - onesc;
            key = delta10 + "#" + delta21;

            if (hm.containsKey(key)) {
                int idx = hm.get(key);
                int len = i - idx;
                ans = Math.max(len, ans);
            } else {
                hm.put(key, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 1, 0, 2, 1, 0, 1, 0, 1, 2, 0, 2};
        System.out.println(getLargestSubArrOFEqual012(arr));
    }
}
