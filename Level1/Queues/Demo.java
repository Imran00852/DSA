package Level1.Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class Demo {
    public static void main(String[] args) {
        Queue<Integer> q=new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.size());
        System.out.println(q.remove());

        System.out.println(q);
    }
}
