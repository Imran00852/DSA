package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class IsomorphicStrings {
    public static boolean checkIsomorphism(String s1, String s2) {
        HashMap<Character, Character> hm1 = new HashMap<>();
        HashMap<Character, Boolean> hm2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (hm1.containsKey(ch1)) {
                if (hm1.get(ch1) != ch2) {
                    return false;
                }
            } else {
                if (hm2.containsKey(ch2)) {
                    return false;
                } else {
                    hm1.put(ch1, ch2);
                    hm2.put(ch2, true);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abacba";
        String s2 = "xyxzyx";

        System.out.println(checkIsomorphism(s1, s2));
    }
}
