package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubarrayWithSum0 {
    public static int countSubArrays(int[] arr) {
        int i = -1;
        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(sum, 1);

        while (i < arr.length - 1) {
            i++;
            sum += arr[i];

            if (hm.containsKey(sum)) {
                count += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        System.out.println(countSubArrays(arr));
    }
}
