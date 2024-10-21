package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class ArrayPairsDivisibleByK {
    public static boolean arrayPairsDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> remCount = new HashMap<>();
        for (int val : arr) {
            int rem = ((val % k) + k) % k;
            remCount.put(rem, remCount.getOrDefault(rem, 0) + 1);
        }

        for (Integer rem : remCount.keySet()) {
            if (rem == 0) {
                if (remCount.get(rem) % 2 != 0) return false;
            } else {
                int count1 = remCount.get(rem);
                int count2 = remCount.getOrDefault(k - rem, 0);
                if (count1 != count2) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        System.out.println(arrayPairsDivByK(arr, 5));
    }
}
