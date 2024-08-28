package Level1.HashmapAndHeap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static class Pair implements Comparable<Pair> {
        int li; //list index
        int di; //data index
        int val; //actual data/val

        public Pair(int li, int di, int val) {
            this.li = li;
            this.di = di;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public static ArrayList<Integer> mergeSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }
        while (pq.size() > 0) {
            Pair p = pq.remove();
            res.add(p.val);
            p.di++;

            if (p.di < lists.get(p.li).size()) {
                p.val = lists.get(p.li).get(p.di);
                pq.add(p);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();

        //l1
        l1.add(2);
        l1.add(4);
        l1.add(6);
        l1.add(8);
        //l2
        l2.add(10);
        l2.add(12);
        l2.add(14);
        l2.add(15);
        //l3
        l3.add(17);
        l3.add(19);
        l3.add(25);
        l3.add(29);

        //add in listOfLists
        listOfLists.add(l1);
        listOfLists.add(l2);
        listOfLists.add(l3);

        ArrayList<Integer> res = mergeSortedLists(listOfLists);
        System.out.println(res);
    }
}
