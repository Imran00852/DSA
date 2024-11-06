package Level2.HashMapsAndHeaps;

import java.util.ArrayList;
import java.util.HashMap;

public class SubDomainVisitCount {
    public static ArrayList<String> getDomainCount(String[] domains) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String domain : domains) {
            String[] tmp = domain.split(" ");
            int visitCount = Integer.parseInt(tmp[0]);

            String[] words = tmp[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                if (i == words.length - 1) {
                    sb.append(words[i]);
                } else {
                    sb.insert(0, ".");
                    sb.insert(0, words[i]);
                }
                String subDomains = sb.toString();
                if (hm.containsKey(subDomains)) {
                    int cvc = hm.get(subDomains);
                    hm.put(subDomains, cvc + visitCount);
                } else {
                    hm.put(subDomains, visitCount);
                }
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (String subDomains : hm.keySet()) {
            StringBuilder sb = new StringBuilder();
            int vCount = hm.get(subDomains);
            sb.append(vCount);
            sb.append(" ");
            sb.append(subDomains);
            res.add(sb.toString());
        }

        return res;
    }

    public static void main(String[] args) {
        String[] domains = {"9001 discuss.leetcode.com", "900 google.mail.com"};
        ArrayList<String> res = getDomainCount(domains);
        System.out.println(res);
    }
}
