package Level1.HashmapAndHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparableAndComparator {
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
            return this.rno - o.rno;
        }

        public String toString() {
            return "r.no=" + this.rno + " " + "wt=" + this.wt + " " + "ht=" + this.ht;
        }
    }

    //height comparator
    public static class StudentHtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.ht - s2.ht;
        }
    }

    //weight comparator
    public static class StudentWtComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.wt - s2.wt;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StudentHtComparator());
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
