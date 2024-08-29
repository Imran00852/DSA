package Level1.HashmapAndHeap;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap {
    public static class PriorityQueue<T> {
        ArrayList<T> data;
        Comparator comp;

        public PriorityQueue() {
            data = new ArrayList<>();
            comp = null;
        }

        public PriorityQueue(Comparator comp) {
            data = new ArrayList<>();
            this.comp = comp;
        }

        public boolean isSmaller(int i, int j) {
            if (comp == null) {
                Comparable ith = (Comparable) data.get(i);
                Comparable jth = (Comparable) data.get(j);
                if (ith.compareTo(jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                T ith = data.get(i);
                T jth = data.get(j);
                if (comp.compare(ith, jth) < 0) {
                    return true;
                } else {
                    return false;
                }
            }

        }

        public int size() {
            return data.size();
        }

        private void swap(int i, int j) {
            T ith = data.get(i);
            T jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);
        }

        private void upheapify(int i) {
            if (i == 0) {
                return;
            }
            int pi = (i - 1) / 2;
            if (isSmaller(i, pi)) {
                swap(i, pi);
                upheapify(pi);
            }
        }

        public void add(T val) {
            data.add(val);
            upheapify(data.size() - 1);
        }

        public T peek() {
            if (this.size() == 0) {
                System.out.println("Nothing in queue");
                return null;
            }

            return data.get(0);
        }

        private void downheapify(int pi) {
            int mini = pi;

            int li = (2 * pi) + 1;
            if (li < data.size() && isSmaller(li, mini)) {
                mini = li;
            }
            int ri = (2 * pi) + 2;
            if (ri < data.size() && isSmaller(ri, mini)) {
                mini = ri;
            }

            if (mini != pi) {
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public T remove() {
            if (this.size() == 0) {
                System.out.println("Nothing in queue");
                return null;
            }
            swap(0, data.size() - 1);
            T val = data.remove(data.size() - 1);
            downheapify(0);
            return val;
        }
    }

    public static class Student implements Comparable<Student> {
        int rno;
        int wt;
        int ht;

        public Student(int rno, int wt, int ht) {
            this.rno = rno;
            this.wt = wt;
            this.ht = ht;
        }

        public int compareTo(Student o) {
            return this.wt - o.wt;
        }

        public String toString() {
            return "r.no=" + this.rno + " " + "wt=" + this.wt + " " + "ht=" + this.ht;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student(1, 50, 170));
        pq.add(new Student(2, 70, 100));
        pq.add(new Student(3, 100, 110));
        pq.add(new Student(4, 80, 150));
        pq.add(new Student(5, 74, 120));

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
