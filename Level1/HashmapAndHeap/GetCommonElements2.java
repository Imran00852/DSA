package Level1.HashmapAndHeap;

import java.util.HashMap;

public class GetCommonElements2 {
    public static void getCommonElements2(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : arr1) {
            if (hm.containsKey(val)) {
                int of = hm.get(val);
                int nf = of + 1;
                hm.put(val, nf);
            } else {
                hm.put(val, 1);
            }
        }
        for (int val : arr2) {
            if (hm.containsKey(val) && hm.get(val) > 0) {
                System.out.print(val + " ");
                int of = hm.get(val);
                int nf = of - 1;
                hm.put(val, nf);
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 6};
        int[] a2 = {1, 1, 2, 2, 2, 3, 3, 6, 7};

        getCommonElements2(a1, a2);
    }
}
