package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubstringsWithKDistinctChars {
    public static int singleDistinctElement(String str) {
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);

                if (hm.size() == 2) {
                    removeFromHm(hm, ch);
                    i--;
                    break;
                }
                f1 = true;
            }

            while (j < i) {
                if (hm.size() == 1) {
                    ans += i - j;
                }
                j++;
                char ch = str.charAt(j);
                removeFromHm(hm, ch);

                if (hm.isEmpty()) {
                    break;
                }
                f2 = true;
            }

            if (!f1 && !f2) break;
        }
        return ans;
    }

    public static int countKDistinctSubstrings(String str, int k) {
        if (k == 1) {
            return singleDistinctElement(str);
        }
        int ans = 0;
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmb = new HashMap<>();

        int is = -1;
        int ib = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            //acquire for big hashmap
            while (ib < str.length() - 1) {
                ib++;
                char ch = str.charAt(ib);
                hmb.put(ch, hmb.getOrDefault(ch, 0) + 1);

                if (hmb.size() > k) {
                    removeFromHm(hmb, ch);
                    ib--;
                    break;
                }
                f1 = true;
            }
            //acquire for small hashmap
            while (is < ib) {
                is++;
                char ch = str.charAt(is);
                hms.put(ch, hms.getOrDefault(ch, 0) + 1);

                if (hms.size() > k - 1) {
                    removeFromHm(hms, ch);
                    is--;
                    break;
                }
                f2 = true;
            }
            //release + make answer
            while (j < is) {
                if (hms.size() == k - 1 && hmb.size() == k) {
                    int len = ib - is;
                    ans += len;
                }
                j++;
                char ch = str.charAt(j);
                removeFromHm(hms, ch);
                removeFromHm(hmb, ch);

                if (hms.size() < k - 1 || hmb.size() < k) break;
                f3 = true;
            }
            if (!f1 && !f2 && !f3) break;
        }
        return ans;
    }

    public static void removeFromHm(HashMap<Character, Integer> hm, char ch) {
        if (hm.get(ch) == 1) {
            hm.remove(ch);
        } else {
            hm.put(ch, hm.get(ch) - 1);
        }
    }

    public static void main(String[] args) {
        String str = "abcabdabbcfa";
        System.out.println(countKDistinctSubstrings(str, 1));
    }
}
