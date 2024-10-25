package Level2.HashMapsAndHeaps;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring2 {
    public static int getMinLengthOfUniqueSubstring(String str) {
        int minL = str.length();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            set.add(ch);
        }

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < str.length() - 1 && hm.size() < set.size()) {
                i++;
                char ch = str.charAt(i);
                hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                f1 = true;
            }
            //get ans then release
            while (j < i && hm.size() == set.size()) {
                int potL = i - j;
                minL = Math.min(potL, minL);

                //release
                j++;
                char ch = str.charAt(j);
                if (hm.get(ch) == 1) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, hm.get(ch) - 1);
                }
                f2 = true;
            }
            if (!f1 && !f2) break;
        }
        return minL;
    }

    public static void main(String[] args) {
        String str = "bbacacdcbbcaadcdca";
        System.out.println(getMinLengthOfUniqueSubstring(str));
    }
}
