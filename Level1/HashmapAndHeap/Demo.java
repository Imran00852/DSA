package Level1.HashmapAndHeap;

import java.util.HashMap;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 600);
        hm.put("Pak", 200);
        hm.put("UK", 300);
        hm.put("Us", 400);
        hm.put("China", 1000);  //no order is maintained when we insert something in hm

        System.out.println(hm);

        System.out.println(hm.get("India")); //600
        System.out.println(hm.get("Utopia")); //null

        System.out.println(hm.containsKey("Utopia")); //false
        System.out.println(hm.containsKey("China")); //true

        //keyset
        Set<String> keys = hm.keySet(); //returns set of all keys in hm
        for (String key : hm.keySet()) {
            Integer val = hm.get(key);
            System.out.println(key + " " + val);
        }
    }
}


//nothing 