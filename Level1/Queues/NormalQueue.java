package Level1.Queues;

public class NormalQueue {
    public static class CustomQueue {
        int[] data;
        int front;
        int size;


        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
        }

        void add(int val) { //add takes place at rear
            if (size == data.length) {
                System.out.println("Queue Overflow");
            }
            int rear = (front + size) % data.length;
            data[rear] = val;
            size++;
        }

        int remove() { //remove takes place at front
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            int val = data[front];
            front = (front + 1) % data.length;
            size--;
            return val;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int val = data[front];
            return val;
        }
    }

    public static void main(String[] args) {
        CustomQueue q = new CustomQueue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println(q.remove());
        System.out.println(q.peek());
        q.display();
    }
}
