package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CountOfSubstringsWithAtmostKDistinctChars {
    public static int countAllSubstrings(String str, int k) {
        int ans = 0;
        int i = -1;
        int j = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (true) {
            while (i < str.length() - 1) {
                i++;
                char ch = str.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);

                if (hm.size() <= k) {
                    ans += i - j;
                } else {
                    break;
                }
            }
            if (i == str.length() - 1 && hm.size() <= k) break;
            while (j < i) {
                j++;
                char ch = str.charAt(j);
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }

                if (hm.size() > k) {
                    continue;
                } else {
                    ans += i - j;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        System.out.println(countAllSubstrings(str, 2));
    }
}
