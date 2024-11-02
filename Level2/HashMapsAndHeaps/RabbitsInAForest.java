package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class RabbitsInAForest {
    public static int getResult(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : arr) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        int ans = 0;
        for (int key : hm.keySet()) {
            int group = key + 1;
            int nominees = hm.get(key);
            int total = (int) Math.ceil((nominees * 1.0) / (group * 1.0));
            ans += total * group;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3, 3, 4, 4, 4, 4};

        System.out.println(getResult(arr));
    }
}
