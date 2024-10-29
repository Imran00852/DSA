package Level2.HashMapsAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class FindAnagramMappings {
    public static class Pair {
        int idx = 0;
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int[] getAnagramMappings(int[] a1, int[] a2) {
        HashMap<Integer, Pair> hm = new HashMap<>();
        for (int i = 0; i < a2.length; i++) {
            if (hm.containsKey(a2[i])) {
                Pair p = hm.get(a2[i]);
                p.list.add(i);
            } else {
                Pair p = new Pair();
                p.list.add(i);
                hm.put(a2[i], p);
            }
        }
        int[] res = new int[a1.length];
        for (int i = 0; i < a1.length; i++) {
            Pair p = hm.get(a1[i]);
            res[i] = p.list.get(p.idx++);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 7, 9, 2, 8, 1, 1, 3, 9};
        int[] a2 = {3, 1, 2, 9, 8, 1, 7, 9, 2};
        int[] res = getAnagramMappings(a1, a2);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
