package Level2.HashMapsAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {
    public static ArrayList<ArrayList<String>> getGroupedAnagrams(String[] arr) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> hm = new HashMap<>();
        for (String str : arr) {
            HashMap<Character, Integer> fmap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
            }

            if (!hm.containsKey(fmap)) {
                ArrayList<String> val = new ArrayList<>();
                val.add(str);
                hm.put(fmap, val);
            } else {
                ArrayList<String> val = hm.get(fmap);
                val.add(str);
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (ArrayList<String> val : hm.values()) {
            res.add(val);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"abcc", "acbc", "badc", "abcd", "dabb", "babd", "dbca", "cabc"};
        ArrayList<ArrayList<String>> res = getGroupedAnagrams(arr);
        System.out.println(res);
    }
}
