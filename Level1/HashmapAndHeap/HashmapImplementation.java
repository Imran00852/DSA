package Level1.HashmapAndHeap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashmapImplementation {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size;  //n  total elements in bucket arr
        private LinkedList<HMNode>[] buckets;  //N bucket size

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        //put
        public void put(K key, V value) {
            //get bucket index from hash function
            int bi = hashFnc(key);
            int di = getIndexWithinBucket(key, bi);  //di=data index

            if (di != -1) {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        //rehash
        private void rehash() {
            LinkedList<HMNode> oba[] = buckets;  //oba=old bucket arr
            initbuckets(oba.length * 2);
            size = 0;

            for (int i = 0; i < oba.length; i++) {
                for (HMNode node : oba[i]) {
                    put(node.key, node.value);
                }
            }
        }

        private int hashFnc(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;  //will get bucket index doing this
        }

        private int getIndexWithinBucket(K key, int bi) {
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        //containsKey
        public boolean containsKey(K key) {
            int bi = hashFnc(key);
            int di = getIndexWithinBucket(key, bi);
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        //get
        public V get(K key) {
            int bi = hashFnc(key);
            int di = getIndexWithinBucket(key, bi);
            if (di != -1) {
                HMNode node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        //remove
        public V remove(K key) {
            int bi = hashFnc(key);
            int di = getIndexWithinBucket(key, bi);
            if (di != -1) {
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            } else {
                return null;
            }
        }

        //size
        public int size() {
            return size;
        }

        //keySet
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 1000);
        hm.put("China", 2000);
        hm.put("UK", 3000);

        System.out.println(hm.containsKey("india"));
        System.out.println(hm.get("india"));
    }
}
