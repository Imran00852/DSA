package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class CheckIfTwoStringsAreKValidAnagrams {
    public static boolean checkKValidAnagrams(String s1, String s2, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (hm.getOrDefault(ch, 0) > 0) {
                hm.put(ch, hm.get(ch) - 1);
            }
        }
        int count = 0;
        for (Character ch : hm.keySet()) {
            count += hm.get(ch);
        }
        if (count > k) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String s1 = "aabbbc";
        String s2 = "badaba";
        System.out.println(checkKValidAnagrams(s1, s2, 3));
    }
}
