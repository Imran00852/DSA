package Level2.HashMapsAndHeaps;

import java.util.HashMap;

public class FindItineraryFromTickets {
    public static void findItinerary(HashMap<String, String> hm) {
        HashMap<String, Boolean> psrc = new HashMap<>();
        for (String src : hm.keySet()) {
            String dest = hm.get(src);

            psrc.put(dest, false);

            if (!psrc.containsKey(src)) {
                psrc.put(src, true);
            }
        }
        String src = "";
        for (String pot : psrc.keySet()) {
            boolean val = psrc.get(pot);
            if (val) {
                src = pot;
                break;
            }
        }

        while (true) {
            if (hm.containsKey(src)) {
                System.out.print(src + "->");
                src = hm.get(src);
            } else {
                System.out.print(src + ".");
                break;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("chennai", "banglore");
        hm.put("bombay", "delhi");
        hm.put("goa", "chennai");
        hm.put("delhi", "goa");

        findItinerary(hm);
    }

}
