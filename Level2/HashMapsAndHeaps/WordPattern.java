package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class WordPattern {
    public static boolean checkWordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        HashMap<Character, String> hm = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if (!hm.containsKey(ch)) {
                if (used.containsKey(words[i])) {
                    return false;
                } else {
                    used.put(words[i], true);
                    hm.put(ch, words[i]);
                }
            } else {
                String mappedWith = hm.get(ch);
                if (!mappedWith.equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abbc";
        String s = "dog cat cat dog";
        System.out.println(checkWordPattern(pattern, s));
    }
}
