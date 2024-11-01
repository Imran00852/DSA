package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubarraysWithEqualZerosOnesAndTwos {
    public static int getCountOf0s1s2s(int[] arr) {
        int ans = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int zcount = 0;
        int ocount = 0;
        int tcount = 0;

        int delta10 = ocount - zcount;
        int delta21 = tcount - ocount;

        String key = delta10 + "#" + delta21;
        hm.put(key, 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zcount++;
            } else if (arr[i] == 1) {
                ocount++;
            } else {
                tcount++;
            }
            delta10 = ocount - zcount;
            delta21 = tcount - ocount;
            key = delta10 + "#" + delta21;

            if (hm.containsKey(key)) {
                ans += hm.get(key);
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 1, 0, 0, 2, 2};
        System.out.println(getCountOf0s1s2s(arr));
    }
}
