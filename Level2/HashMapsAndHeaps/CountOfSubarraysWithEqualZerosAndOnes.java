package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubarraysWithEqualZerosAndOnes {
    public static int countSubarraysWithEqualZAO(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (hm.containsKey(sum)) {
                ans += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        System.out.println(countSubarraysWithEqualZAO(arr));
    }
}
