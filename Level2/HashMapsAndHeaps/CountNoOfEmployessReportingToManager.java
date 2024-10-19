package Level2.HashMapsAndHeaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CountNoOfEmployessReportingToManager {
    public static void countEmployees(HashMap<String, String> hm) {
        HashMap<String, HashSet<String>> tree = new HashMap<>();
        String ceo = "";
        for (String emp : hm.keySet()) {
            String man = hm.get(emp); //get manager

            if (man.equals(emp)) {
                ceo = man;
            } else {
                if (tree.containsKey(man)) {
                    HashSet<String> emps = tree.get(man);
                    emps.add(emp);
                } else {
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(man, emps);
                }
            }
        }
        HashMap<String, Integer> res = new HashMap<>();
        getSize(tree, ceo, res);

        System.out.println(res);
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> res) {
        if (!tree.containsKey(man)) {
            res.put(man, 0);
            return 1;
        }
        int size = 0;
        for (String emps : tree.get(man)) {
            int cs = getSize(tree, emps, res);
            size += cs;
        }
        res.put(man, size);
        return size + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(sc.next(), sc.next());
        }

        countEmployees(hm);
    }
}
