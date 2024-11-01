package Level2.HashMapsAndHeaps;

import java.util.HashMap;

//find longest subarr with equal 0 and 1
public class ContiguousArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0};
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        hm.put(sum, -1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }

            if (hm.containsKey(sum)) {
                int idx = hm.get(sum);
                int len = i - idx;

                ans = Math.max(ans, len);
            } else {
                hm.put(sum, i);
            }
        }
        System.out.println(ans);
    }
}
