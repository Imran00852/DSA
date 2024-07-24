package Level1.LinkedList;

import java.util.LinkedList;

public class LinkedListToQueueAdapter {
    LinkedList<Integer> list;
    public LinkedListToQueueAdapter(){
        list=new LinkedList<>();
    }

    int size(){
        return list.size();
    }
    void add(int data){
        list.addLast(data);
    }
    int remove(){
        return list.removeFirst();
    }
    int peek(){
        return list.getFirst();
    }
    void display() {
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListToQueueAdapter queue=new LinkedListToQueueAdapter();
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue.peek());
        System.out.println(queue.remove());
        queue.display();
    }
}
