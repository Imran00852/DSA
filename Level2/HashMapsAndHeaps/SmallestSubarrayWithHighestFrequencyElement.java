package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class SmallestSubarrayWithHighestFrequencyElement {
    public static void getSmallestSubarray(int[] arr) {
        int hfreq = 0;
        int si = 0;
        int ei = 0;
        int len = ei - si + 1;

        HashMap<Integer, Integer> fmap = new HashMap<>();
        HashMap<Integer, Integer> imap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (fmap.containsKey(arr[i])) {
                fmap.put(arr[i], fmap.get(arr[i]) + 1);
            } else {
                fmap.put(arr[i], 1);
                imap.put(arr[i], i);
            }

            if (fmap.get(arr[i]) > hfreq) {
                hfreq = fmap.get(arr[i]);
                si = imap.get(arr[i]);
                ei = i;
                len = ei - si + 1;
            } else if (fmap.get(arr[i]) == hfreq) {
                int clen = i - imap.get(arr[i]) + 1;
                if (clen < len) {
                    hfreq = fmap.get(arr[i]);
                    si = imap.get(arr[i]);
                    ei = i;
                    len = ei - si + 1;
                }
            }
        }
        System.out.println(si + "," + ei);
        System.out.println(arr[si]); //highest freq element
        System.out.println(hfreq); //highest freq
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2, 3, 4, 2, 5, 6, 5, 5, 7};
        getSmallestSubarray(arr);
    }
}
