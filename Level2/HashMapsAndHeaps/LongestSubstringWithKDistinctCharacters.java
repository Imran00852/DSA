package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {
    public static int countKDistinctChars(String str, int k) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            //acquire
            while (i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                if (hm.size() > k) {
                    break;
                } else if (hm.size() == k) {
                    int len = i - j;
                    ans = Math.max(len, ans);
                }
                f1 = true;
            }
            //release
            while (j < i) {
                j++;
                char ch = str.charAt(j);
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
                if (hm.size() == k) {
                    int len = i - j;
                    ans = Math.max(len, ans);
                    break;
                }
                f2 = true;
            }

            if (!f1 && !f2) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(countKDistinctChars(str, 2));
    }
}
