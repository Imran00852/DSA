package Level2.HashMapsAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistnictElementsInWindowSizedK {
    public static ArrayList<Integer> countDistinctElements(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i = 0;
        while (i < k - 1) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            i++;
        }
        i--;
        int j = -1;
        while (i < arr.length - 1) {
            //aquire;
            i++;
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

            //add in ArrayList
            res.add(hm.size());

            //release
            j++;
            int freq = hm.get(arr[j]);
            if (freq == 1) {
                hm.remove(arr[j]);
            } else {
                hm.put(arr[j], hm.getOrDefault(arr[j], 0) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
        ArrayList<Integer> res = countDistinctElements(arr, 4);
        System.out.println(res);
    }
}
