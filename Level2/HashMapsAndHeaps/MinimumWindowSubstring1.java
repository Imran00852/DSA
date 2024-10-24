package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class MinimumWindowSubstring1 {
    public static String getMinimumSubstringContainingCharsOfS2(String s1, String s2) {
        String ans = "";
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            hm2.put(ch, hm2.getOrDefault(ch, 0) + 1);
        }
        int i = -1;
        int j = -1;
        int dmc = s2.length(); //dmc=desiredMatchCount
        int mtc = 0;  //mtc=match count;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            //acquire
            while (i < s1.length() - 1 && mtc < dmc) {
                i++;
                char ch = s1.charAt(i);
                hm1.put(ch, hm1.getOrDefault(ch, 0) + 1);

                if (hm1.getOrDefault(ch, 0) <= hm2.getOrDefault(ch, 0)) {
                    mtc++;
                }
                f1 = true;
            }
            //get answer, then release
            while (j < i && mtc == dmc) {
                String pot = s1.substring(j + 1, i + 1);
                if (ans.isEmpty() || pot.length() < ans.length()) {
                    ans = pot;
                }
                j++;
                char ch = s1.charAt(j);
                if (hm1.get(ch) == 1) {
                    hm1.remove(ch);
                } else {
                    hm1.put(ch, hm1.get(ch) - 1);
                }

                if (hm1.getOrDefault(ch, 0) < hm2.getOrDefault(ch, 0)) {
                    mtc--;
                }
                f2 = true;
            }

            if (f1 == false && f2 == false) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "dbaecbbabdcaaafbddcabgba";
        String s2 = "abbcdc";

        System.out.println(getMinimumSubstringContainingCharsOfS2(s1, s2));
    }
}
