package Level1.HashmapAndHeap;

import java.util.HashMap;

public class HighestFrequencyCharacter {
    public static void getHighestFreqChar(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                int oldFreq = hm.get(ch);
                int newfreq = oldFreq + 1;
                hm.put(ch, newfreq);
            } else {
                hm.put(ch, 1);
            }
        }
        int count = 1;
        char maxFreqChar = str.charAt(0);
        for (Character key : hm.keySet()) {
            if (hm.get(key) > maxFreqChar) {
                maxFreqChar = key;
            }
            if (hm.get(key) > count) {
                count = hm.get(key);
            }
        }

        System.out.println(maxFreqChar);
        System.out.println(count);

    }

    public static void main(String[] args) {
        String str = "abrakadabra";
        getHighestFreqChar(str);
    }
}
