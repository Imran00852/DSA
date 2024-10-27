package Level2.HashMapsAndHeaps;

import java.util.HashMap;
import java.util.HashSet;

public class CountOfEquivalentSubarrays {
    public static int getCountOfEquivalentSubArr(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : arr) {
            set.add(val);
        }
        int count = 0;
        int i = -1;
        int j = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < arr.length - 1) {
                i++;
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

                if (hm.size() == set.size()) {
                    count += arr.length - i;
                    break;
                }
                f1 = true;
            }
            //release
            while (j < i) {
                j++;
                if (hm.get(arr[j]) == 1) {
                    hm.remove(arr[j]);
                } else {
                    hm.put(arr[j], hm.get(arr[j] - 1));
                }

                if (hm.size() == set.size()) {
                    count += arr.length - i;
                } else {
                    break;
                }
                f2 = true;
            }
            if (!f1 && !f2) break;
        }

        return count;

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 5, 2, 4, 1, 3, 1, 4};
        System.out.println(getCountOfEquivalentSubArr(arr));
    }
}
