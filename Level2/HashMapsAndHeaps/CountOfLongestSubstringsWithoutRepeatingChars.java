package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfLongestSubstringsWithoutRepeatingChars {
    public static int countSubstrings(String str) {
        int count = 0;
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
                if (hm.get(ch) == 2) {
                    break;
                } else {
                    count += i - j;
                }
                f1 = true;
            }
            //release
            while (j < i) {
                j++;
                char ch = str.charAt(j);
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 1) {
                    count += i - j;
                    break;
                }
                f2 = true;
            }

            if (!f1 && !f2) break;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(countSubstrings(str));
    }
}
