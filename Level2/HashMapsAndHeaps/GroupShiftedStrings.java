package Level2.HashMapsAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupShiftedStrings {
    public static String getKey(String str) {
        String key = "";
        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            int diff = curr - prev;

            if (diff < 0) {
                diff += 26;
            }

            key += diff + "#";
        }
        key += ".";
        return key;
    }

    public static ArrayList<ArrayList<String>> getShiftedStrings(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (!hm.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hm.put(key, list);
            } else {
                ArrayList<String> list = hm.get(key);
                list.add(str);
            }
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (ArrayList<String> val : hm.values()) {
            res.add(val);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "x", "a", "moqs"};
        ArrayList<ArrayList<String>> res = getShiftedStrings(strs);
        System.out.println(res);
    }
}
