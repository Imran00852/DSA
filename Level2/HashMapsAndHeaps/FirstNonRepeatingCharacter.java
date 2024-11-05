package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static int getFirstNonRepeatingChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "abbcaddecfab";

        System.out.println(getFirstNonRepeatingChar(str));
    }
}
